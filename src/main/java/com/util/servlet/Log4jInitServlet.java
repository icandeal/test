package com.util.servlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.InputStream;

/**
 * Created by sniper on 2016/3/12.
 */
public class Log4jInitServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(Log4jInitServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        String fileName = config.getInitParameter("log4j");
        if(fileName!=null){
            InputStream input = this.getClass().getResourceAsStream(fileName);
            PropertyConfigurator.configure(input);
            logger.info("LOG4J is RUN !!");
        }
    }
}
