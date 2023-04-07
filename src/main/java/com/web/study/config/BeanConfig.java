package com.web.study.config;

import com.web.study.IocAndDi.TestC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public TestC testC() {
        return new TestC();
    };
}
