package com.web.study.security;

import com.web.study.domain.entity.user.User;
import com.web.study.exception.CustomException;
import com.web.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findUserByUsername(username);

        if(userEntity == null) {
            throw new CustomException("존재하지 않는 사용자입니다.");
        }
        return userEntity.toPrincipal();
    }
}
