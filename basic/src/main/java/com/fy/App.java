package com.fy;

import com.fy.component.ConfigurableComponent;
import com.fy.service.ChildService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
//@EnableLoadTimeWeaving
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        Object abc = run.getBean("abc");
        Object aaa = run.getBean("aaa");
        System.out.println(aaa);
        ConfigurableComponent configurableComponent = new ConfigurableComponent();
        System.out.println(configurableComponent);
        ChildService bean = run.getBean(ChildService.class);
        bean.parentMethod1();
        bean.parentMethod2();
    }
}
