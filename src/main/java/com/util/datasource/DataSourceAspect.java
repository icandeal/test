package com.util.datasource;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by sniper on 2016/3/19.
 */
@Component
@Aspect
public class DataSourceAspect {
    private static Logger logger = Logger.getLogger(DataSourceAspect.class);
//    @Pointcut("execution(* com.dao.mapper.*.*(..))")
//    public void inAspect(){
//        System.out.println("In the AspectJ");
//    }

    @Before("execution(* com.dao.*.*.*(..))")
    public void before(JoinPoint point) {
        logger.debug("This is AspectJ !!");
        Object target = point.getTarget();
        String method = point.getSignature().getName();

        //用于从 interface 中继承的方法，annotation 在 interface 定义方法时声明
        Class<?>[] clazz = target.getClass().getInterfaces();
        Class<?>[] parameterType = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();

        try {
            Method m = null;

            if (clazz != null || clazz.length > 0) {
                m = clazz[0].getMethod(method, parameterType);
            }
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                DataSourceContextHolder.setCustomerType(data.value());
            } else {
                m = target.getClass().getMethod(method, parameterType);
                if (m != null && m.isAnnotationPresent(DataSource.class)) {
                    DataSource data = m.getAnnotation(DataSource.class);
                    DataSourceContextHolder.setCustomerType(data.value());
                } else {
                    DataSourceContextHolder.setCustomerType("mysql");
                }
            }
        } catch (Exception e) {
            logger.error("DataSource aspect error !!!!");
        }
    }

}
