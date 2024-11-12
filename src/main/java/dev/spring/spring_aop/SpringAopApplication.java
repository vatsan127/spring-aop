package dev.spring.spring_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringAopApplication.class, args);
        RunService runService = context.getBean(RunService.class);

        try {
            runService.run();
            runService.afterReturning("Welcome");
            runService.throwError();
        } catch (Exception ex) {
            System.out.println("Exception handled in main: " + ex.getMessage());
        }
    }
}
