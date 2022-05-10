package com.fy.service;

import com.fy.annotation.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@MyAnnotation
public class ChildService extends ParentService{

    @Override
    public void parentMethod2() {
        super.parentMethod2();
        log.info("parentMethod2 in child");
    }
}
