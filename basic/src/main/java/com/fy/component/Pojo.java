package com.fy.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Pojo {

    @Bean
    public String aaa(){
        log.info("aaa");
        return "aaa";
    }
}
