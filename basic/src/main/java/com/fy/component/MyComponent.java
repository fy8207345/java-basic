package com.fy.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Configuration
@Slf4j
public class MyComponent {

    @Bean
    @DependsOn(value = "aaa")
    public String abc(String aaa){
        log.info("aaa:{}", aaa);
        return "abc";
    }
}
