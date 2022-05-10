package com.fy.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("bean2")
@Slf4j
public class Bean1 implements InitializingBean, DisposableBean {

    @Autowired
    private Bean2 bean2;

    public Bean1() {
        log.info("Bean1 created: {} - {}", this, bean2);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Bean1 afterPropertiesSet: {} - {}", this, bean2);
    }

    @Override
    public void destroy() throws Exception {
        log.info("Bean1 destroy: {} - {}", this, bean2);
    }
}
