package org.program.SpringAOP.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorAspect.class);

    @Around("execution(* org.program.SpringAOP.service.JobService.getAllJobs(..)) || " +
            "execution(* org.program.SpringAOP.service.JobService.getJob(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object o=jp.proceed();
        long endTime=System.currentTimeMillis();
        System.out.println("Time Taken by : "+jp.getSignature().getName() +" : "+(endTime-startTime)+"ms");
        return o;
    }

}
