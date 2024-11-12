package dev.spring.spring_aop;

import org.springframework.stereotype.Service;

@Service
public class RunService {

    public void run() {
//        throwError();
//        afterReturning();
    }

    String afterReturning(String str) {
        return str;
    }

    public void throwError() {
        throw new RuntimeException("This is a runtime exception");
    }

}
