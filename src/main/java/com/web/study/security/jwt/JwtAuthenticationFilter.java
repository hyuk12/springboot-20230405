package com.web.study.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String token = resolveToken((HttpServletRequest) servletRequest);

        // 토큰이 유효한 토큰인지 확인
        boolean validationFlag = jwtTokenProvider.validateToken(token);
        System.out.println("validationFlag = " + validationFlag);

        // 헤더에서 토큰을 받아온다.
        if(validationFlag) {
            // 토큰을 통해 유저 정보를 받아온다.
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            // SecurityContext 에 Authentication 객체를 저장한다.
            // 이후 @AuthenticationPrincipal 어노테이션을 통해 유저 정보를 받아올 수 있다.
            // SecurityContext 는 ThreadLocal 로 구현되어 있어서, 다른 쓰레드에서는 SecurityContext 를 공유하지 않는다.
            // 따라서, 다른 쓰레드에서 SecurityContext 를 사용하려면, 직접 SecurityContext 를 설정해주어야 한다.
            // SecurityContextHolder.setContext(securityContext);
            // 인증이 완료 된 것이다.
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 항상 필수
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String resolveToken(HttpServletRequest servletRequest) {
        String bearerToken = servletRequest.getHeader("Authorization");
        String bearer = "Bearer";

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(bearer)) {
            return bearerToken.substring(bearer.length() + 1);
        }

        return null;
    }
}
