package com.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

/**
 * Created by sniper on 2016/3/20.
 */
public class BaseController<T> implements Serializable {

    private static Logger logger = Logger.getLogger(BaseController.class);

    public <T> Object getParameter(HttpServletRequest request,
                                   Class<? extends Object> clazz) {
        if (request == null || clazz == null)
            return null;

        Object obj = null;
        try {
            Enumeration<String> paraNameStrArr = request.getParameterNames();
            if (paraNameStrArr != null) {
                obj = clazz.newInstance();
                while (paraNameStrArr.hasMoreElements()) {
                    String paraNameStr = paraNameStrArr.nextElement();
                    Object paraVal = request.getParameter(paraNameStr);
                    // 进行封装成Entity
                    if (clazz != null && obj != null && paraVal != null) {
                        // _empty适用于jgrid的添加
                        if (paraVal != null &&paraVal.toString().length()>0 && !paraVal.equals("_empty")){
                            BeanUtils.copyProperty(obj, paraNameStr, paraVal);
                        }

                    }
                }
            }
        } catch (InstantiationException e) {
            logger.error(e);
            return null;
        } catch (IllegalAccessException e) {
            logger.error(e);
            return null;
        } catch (InvocationTargetException e) {
            logger.error(e);
            return null;
        }
        return (T) obj;
    }
}
