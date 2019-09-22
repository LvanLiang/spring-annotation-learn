package com.liang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 *
 * @author Liangxp
 * @date 2019-06-24 11:53
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public * com.liang.aop.*.*(..))")
    public void pointcut(){}

    @Before("com.liang.aop.LogAspect.pointcut()")
    public void logStart(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("@Before..."+methodName+"方法执行，参数："+ Arrays.asList(args));
    }

    @After("pointcut()")
    public void logEnd(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("@After..."+methodName+"方法执行，参数："+ Arrays.asList(args));
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("@AfterReturning..."+methodName+"方法执行，参数："+ Arrays.asList(args));
    }

    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println("@AfterThrowing..."+joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exception+"}");
    }

}
