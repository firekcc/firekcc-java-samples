package cc.firek.spring.practice.async.config;

import cc.firek.spring.practice.async.handler.AsyncInterceptor;
import cc.firek.spring.practice.async.handler.AsyncWebRequestHandlerInterceptorAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AsyncWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AsyncWebRequestHandlerInterceptorAdapter(new AsyncInterceptor())).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
