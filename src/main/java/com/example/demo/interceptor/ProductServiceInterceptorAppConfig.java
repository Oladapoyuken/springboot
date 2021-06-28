package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//This class works with the ProductServiceInterceptor to perform its function of intercepting response and request


//@Component
public class ProductServiceInterceptorAppConfig extends WebMvcConfigurerAdapter{
    @Autowired
    ProductServiceInterceptor psi;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(psi);
    }
}
