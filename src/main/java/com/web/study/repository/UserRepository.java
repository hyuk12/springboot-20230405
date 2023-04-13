package com.web.study.repository;

import com.web.study.domain.entity.user.Authority;
import com.web.study.domain.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    public int saveUser(User user);
    public int addAuthorities(List<Authority> authorities);
    public User findUserByUsername(String username);
}
