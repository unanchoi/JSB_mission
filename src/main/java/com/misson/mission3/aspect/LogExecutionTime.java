package com.misson.mission3.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //어디에 붙을 수 있는 target인지 지정
@Retention(RetentionPolicy.RUNTIME)// annotation이 어느 시점까지 존재할 것인지 지정
public @interface LogExecutionTime {

}
