package com.fy.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import javax.annotation.PostConstruct;

@Slf4j
@Configurable
@EnableSpringConfigured
public class ConfigurableComponent {

    public ConfigurableComponent() {
        log.error("ConfigurableComponent");
    }

    private String abc;

    @Autowired
    public void setAbc(String abc){
        log.error("setAbc: {}", abc);
        this.abc = abc;
    }

    @PostConstruct
    public void init(){
        log.error("init: {}", this);
    }

    @Override
    public String toString() {
        log.error("tostring: {}", abc);
        return abc;
    }
}
