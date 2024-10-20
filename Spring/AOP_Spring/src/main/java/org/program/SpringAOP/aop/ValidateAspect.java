package org.program.SpringAOP.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidateAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateAspect.class);

    @Around("execution(* org.program.SpringAOP.service.JobService.getJob(..)) && args(postID)")
    public Object validateInput(ProceedingJoinPoint jp,int postID) throws Throwable {
        if(postID<0){
            LOGGER.info("Invalid Input : "+postID +", updating it");
            postID=Math.abs(postID);
            LOGGER.info("New Value is : "+postID);
        }
        Object o=jp.proceed(new Object[]{postID});
        return o;
    }
}
