package com.dao.impl;

import com.dao.inter.ITestAnnotation;
import com.util.datasource.DataSource;
import org.springframework.stereotype.Component;

/**
 * Created by sniper on 2016/3/26.
 */
@Component
public class TestAnnotation implements ITestAnnotation {
    @DataSource("mysql")
    public void doSome(){
        System.out.println("ssssss");
    }
}
