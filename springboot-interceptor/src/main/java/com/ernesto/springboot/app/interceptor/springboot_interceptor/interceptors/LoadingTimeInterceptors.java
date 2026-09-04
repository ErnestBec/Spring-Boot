package com.ernesto.springboot.app.interceptor.springboot_interceptor.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptors implements HandlerInterceptor{

    private static final Logger loger = LoggerFactory.getLogger(LoadingTimeInterceptors.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
                loger.info("LoadingTimeInterceptor: postHanlde() saliendo ..."+ ((HandlerMethod) handler).getMethod().getName());
      
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                loger.info("LoadingTimeInterceptor: preHanlde() entrando ..." + ((HandlerMethod) handler).getMethod().getName());
        return true;
    }

    

}
    