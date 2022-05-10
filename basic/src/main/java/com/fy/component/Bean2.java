package com.fy.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bean2 implements InitializingBean, DisposableBean {

    public Bean2() {
        log.info("bean2 created: {}", this);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("bean2 afterPropertiesSet: {}", this);
    }

    @Override
    public void destroy() throws Exception {
        log.info("bean2 destroy: {}", this);
    }
}
