package dev.spring.spring_aop.aspect;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @PostConstruct
    public void init() {
        logger.info("LoggingAspect Bean Created!");
    }

    // Pointcut for all methods in 'run' package
    @Pointcut("execution(* dev.spring.spring_aop.RunService.*(..))")
    public void allRunMethods() {
    }

    // Log before all methods in 'run' package
    @Before("allRunMethods()")
    public void logBefore(JoinPoint joinPoint) {
        // Log the method signature
        logger.info("Message from AOP: Method " + joinPoint.getSignature() + " is about to be called.");

        // Log the method parameters
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            logger.info("Method parameters: " + Arrays.toString(args));
        } else {
            logger.info("Method has no parameters.");
        }
    }

    // Log return values for all methods in 'run' package
    @AfterReturning(pointcut = "allRunMethods()", returning = "value")
    public void logReturn(JoinPoint joinPoint, Object value) {
        if (value != null) {
            logger.info("Message from AOP " + joinPoint.getSignature() + " returned with value: " + value);
        } else {
            logger.info("Message from AOP " + joinPoint.getSignature() + " completed with no return value.");
        }
    }

    // Pointcut for `throwError` method in RunService
    @Pointcut("execution(* dev.spring.spring_aop.RunService.throwError(..))")
    public void throwErrorPointcut() {
    }

    // Log exception for `throwError` method in RunService
    @AfterThrowing(pointcut = "throwErrorPointcut()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.severe("Exception from AOP in method: " + joinPoint.getSignature());
        logger.severe("Exception message: " + ex.getMessage());
    }
}
