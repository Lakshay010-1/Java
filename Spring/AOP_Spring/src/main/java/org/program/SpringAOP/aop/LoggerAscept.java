package org.program.SpringAOP.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAscept {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAscept.class);

    //Advice("PointCut")
    //PointCut="return-type class-name.method-name(args)"
    @Before("execution(* org.program.SpringAOP.service.JobService.getAllJobs(..)) || " +
            "execution(* org.program.SpringAOP.service.JobService.getJob(..))" )
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Logger Called for " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* org.program.SpringAOP.service.JobService.getAllJobs(..)) || " +
            "execution(* org.program.SpringAOP.service.JobService.getJob(..))" )
    public void logMethodSuccess(JoinPoint jp){
        LOGGER.info("Logger Called Successfully for " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* org.program.SpringAOP.service.JobService.getAllJobs(..)) || " +
            "execution(* org.program.SpringAOP.service.JobService.getJob(..))" )
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Logger Called Crashed for " + jp.getSignature().getName());
    }

    @After("execution(* org.program.SpringAOP.service.JobService.getAllJobs(..)) || " +
            "execution(* org.program.SpringAOP.service.JobService.getJob(..))" )
    public void logMethodFinally(JoinPoint jp){
        LOGGER.info("Logger Called Finally Executed for " + jp.getSignature().getName());
    }

}
