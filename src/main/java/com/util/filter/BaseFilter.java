package com.util.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by sniper on 2016/2/28.
 */
public class BaseFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init!!");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter doFilter!!");

        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("Filter destroy!!");
    }
}
