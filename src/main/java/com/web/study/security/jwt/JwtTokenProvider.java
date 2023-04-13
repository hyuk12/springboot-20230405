package com.web.study.security.jwt;

import com.web.study.dto.response.auth.JwtTokenRespDto;
import com.web.study.security.PrincipalUserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Key key;


    public JwtTokenProvider(@Value("${jwt.secretKey}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public JwtTokenRespDto createToken(Authentication authentication) {
//        StringBuilder sb =  new StringBuilder();
//
//        authentication.getAuthorities().forEach(grantedAuthority -> {
//            sb.append(grantedAuthority.getAuthority());
//            sb.append(",");
//        });
//
//        sb.delete(sb.length() - 1, sb.length());

        String authorities = authentication.getAuthorities()
                            .stream()
                            .map(authority -> authority.getAuthority())
                            .reduce((a, b) -> a + "," + b)
                            .orElse("");

        long now = (new Date()).getTime();
        Date tokenExpiresDate = new Date(now + (1000 * 60 * 30)); // token 만료 시간 30분

        PrincipalUserDetails userDetails = (PrincipalUserDetails) authentication.getPrincipal();

        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("userId", userDetails.getUserId())
                .claim("auth", authorities)
                .setExpiration(tokenExpiresDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return JwtTokenRespDto.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .build();
    }
}
