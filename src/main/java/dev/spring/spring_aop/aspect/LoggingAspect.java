package dev.spring.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterReturning(value = "execution(* dev.spring.spring_aop.run.*.*(..))", returning = "value")
    public void logReturn(JoinPoint joinPoint, Object value) {
        logger.log(Level.INFO, joinPoint.getSignature() + " method returned successfully with value : " + value);
    }

    @AfterThrowing(value = "execution(* dev.spring.spring_aop.run.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.log(Level.INFO, joinPoint.getSignature() + " Exception occurred due to " + ex.getMessage());

    }
}
