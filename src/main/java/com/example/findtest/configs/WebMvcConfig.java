package com.example.findtest.configs;

import com.example.findtest.interceptors.Sessionlnterceptors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public Sessionlnterceptors sessionlnterceptors() {return new Sessionlnterceptors();}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.sessionlnterceptors())
                .addPathPatterns("/main/textadd")
                .excludePathPatterns("/user/login,","/user/join","/resources/**","/**/*.css","/**/*.js","/**/*.html");

    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(false);
    }
}
