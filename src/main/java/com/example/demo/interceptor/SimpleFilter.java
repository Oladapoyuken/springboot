package com.example.demo.interceptor;

import com.example.demo.exception.UnauthorizedAccessException;

import javax.servlet.*;
import java.io.IOException;

//@Component
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Remote Host: " + servletRequest.getRemoteHost());
        System.out.println("Remote Address: " + servletRequest.getRemoteAddr());

        if(servletRequest.getRemoteHost().equals("127.0.0.1")) throw new UnauthorizedAccessException();

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
