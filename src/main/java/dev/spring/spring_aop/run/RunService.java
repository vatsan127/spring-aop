package dev.spring.spring_aop.run;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class RunService {
    private final Logger logger = Logger.getLogger(RunService.class.getName());

    public int run() {
        int returnValue = 1;

        if (returnValue == 1) {
            throwError();
        }
        return returnValue;
    }

    public void throwError() {
        throw new RuntimeException("This is a runtime exception");
    }

}
