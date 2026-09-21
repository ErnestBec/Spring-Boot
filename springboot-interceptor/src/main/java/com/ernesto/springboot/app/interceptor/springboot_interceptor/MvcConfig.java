package com.ernesto.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    private final HandlerInterceptor timeInterceptor;

    

    public MvcConfig(@Qualifier("timeInterceptor") HandlerInterceptor timeInterceptor) {
        this.timeInterceptor = timeInterceptor;
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //Agrega rutas al interceptor
        registry.addInterceptor(timeInterceptor).addPathPatterns("/app/foo", "/app/baz");
        //Exluye rutas al interceptor
        // registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/foo");
    }



}
