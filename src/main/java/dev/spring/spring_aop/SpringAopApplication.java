package dev.spring.spring_aop;

import dev.spring.spring_aop.run.RunService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringAopApplication.class, args);
        RunService runBean = run.getBean(RunService.class);
        runBean.run();
    }

}
