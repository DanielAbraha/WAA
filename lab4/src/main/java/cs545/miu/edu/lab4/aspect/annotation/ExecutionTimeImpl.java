package cs545.miu.edu.lab4.aspect.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeImpl {

    @Pointcut("@annotation(cs545.miu.edu.lab4.aspect.annotation.ExecutionTIme)")
    public void executionTimeAnnotation(){

    }


    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint point) throws Throwable{
        long start = System.nanoTime();
        var result = point.proceed();
        long finish = System.nanoTime();
        System.out.println(point.getSignature().getName() +" takes ns: " + (finish-start)); // if we want to print it in the console.
        return result;
    }
}
