package ru.geekbrains.market.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



@Aspect
@Component

public class AspectClass {


    @Around("execution(public * ru.geekbrains.market.services.ProductsService.*(..))")
    public Object methodProfilingProductsService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start profiling");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println(proceedingJoinPoint.getSignature() + " duration: " + duration);
        System.out.println("end profiling");
        return out;
    }

    @Around("execution(public * ru.geekbrains.market.services.CartService.*(..))")
    public Object methodProfilingCartService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start profiling");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println(proceedingJoinPoint.getSignature() + " duration: " + duration);
        System.out.println("end profiling");
        return out;
    }

    @Around("execution(public * ru.geekbrains.market.services.UserService.*(..))")
    public Object methodProfilingUserService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start profiling");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println(proceedingJoinPoint.getSignature() + " duration: " + duration);
            System.out.println("end profiling");
            return out;

    }
    //Реализовать вывод суммарного времени на работу всех методов сервиса не получилось...
}

