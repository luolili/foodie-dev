package com.luo.aspect;

import com.luo.controller.HaloController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLogAspect {

    private static final Logger log = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * 1.前置通知
     * 2.后置通知
     * 3.环绕通知
     * 4.异常通知
     * 5.最终通知
     * <p>
     * 第一个 * 表示任何返回值
     * 第二处 ： 所在的包:..包下面类的所有方法
     */
    @Around("execution(* com.luo.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //类名，方法名
        log.info("==start:{},{}==",
                joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();//执行方法
        long end = System.currentTimeMillis();
        long takeTime = end - begin;
        if (takeTime > 3000) {
            log.error("end==耗时：{}== ms", takeTime);
        } else if (takeTime > 2000) {
            log.warn("end==耗时：{}== ms", takeTime);
        } else {
            log.info("end==耗时：{}== ms", takeTime);
        }
        return result;
    }
}
