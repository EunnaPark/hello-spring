package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //use instead of registering bean  relate to AOP
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))" ) // relate to AOP
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        System.out.println("Start: " + joinPoint.toString());
        try{

            return joinPoint.proceed();
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("End : " + joinPoint.toString()+ timeMs + "ms");
        }
    }
}
