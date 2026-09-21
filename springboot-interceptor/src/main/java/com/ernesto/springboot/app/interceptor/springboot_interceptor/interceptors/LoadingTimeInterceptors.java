package com.ernesto.springboot.app.interceptor.springboot_interceptor.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component("timeInterceptor")
public class LoadingTimeInterceptors implements HandlerInterceptor {

    private static final Logger loger = LoggerFactory.getLogger(LoadingTimeInterceptors.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        loger.info(
                "LoadingTimeInterceptor: preHanlde() entrando ..." + ((HandlerMethod) handler).getMethod().getName());

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);

        // Map<String, String> json = new HashMap<>();
        // json.put("error", "no tienes acceso a esta pagina!!");
        // json.put("date", new Date().toString());

        // ObjectMapper mapper = new ObjectMapper();
        // String jsonString = mapper.writeValueAsString(json);
        // response.setContentType("application/json");
        // response.setStatus(401);
        // response.getWriter().write(jsonString);

        // return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

        long end = System.currentTimeMillis();
        long start = (Long) request.getAttribute("start");
        long result = end - start;
        loger.info("Tiempo transcurrido: " + result + " milisegundoss");
        loger.info(
                "LoadingTimeInterceptor: postHanlde() saliendo ..." + ((HandlerMethod) handler).getMethod().getName());

    }
}
