package com.util.common;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sniper on 2016/3/26.
 */
public class UtilTool {
//    public <T> getParameter(HttpServletRequest request, Class<?> clazz){
//
//        return (T) clazz;
//    }

    public static boolean isEmpty(String str){
        if(str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
}
