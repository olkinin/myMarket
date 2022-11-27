package ru.geekbrains.market.controllers;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;

import org.springframework.web.bind.annotation.*;

import ru.geekbrains.market.utils.AspectClass;

@RestController
@RequiredArgsConstructor
public class AopController {
    private final AspectClass aspectClass;


    @GetMapping ("/statistic ")
    public Object statistic (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
             return aspectClass.methodProfilingProductsService(proceedingJoinPoint);
 
    }
}