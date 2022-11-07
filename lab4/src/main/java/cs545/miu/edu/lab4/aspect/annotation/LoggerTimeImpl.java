package cs545.miu.edu.lab4.aspect.annotation;

import cs545.miu.edu.lab4.domain.Logger;
import cs545.miu.edu.lab4.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoggerTimeImpl {

    @Autowired
    LoggerService loggerService;


    @Around("execution(* cs545.miu.edu.lab4.controller.UserController.*(..))")

    public Object around(ProceedingJoinPoint point) throws Throwable {
         Object result = null;
         long beginTime = System.currentTimeMillis();
          result = point.proceed();   // beginning of Execution

             // saving
        saveLogger(point,beginTime);

       return result;
    }
      private void saveLogger(ProceedingJoinPoint point,long time) throws Throwable {
        Logger logger = new Logger();
         long start = System.nanoTime();
         point.proceed();

         long finish = System.nanoTime();
         logger.setTime(finish-start);
          // to be able to store in database
          HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

          logger.setOperation(request.getMethod());
          logger.setPrinciple(" principle 1");
          logger.setOperation("operation 1");
          loggerService.save(logger);
      }




}
