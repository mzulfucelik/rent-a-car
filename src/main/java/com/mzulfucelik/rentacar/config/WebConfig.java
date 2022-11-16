package com.mzulfucelik.rentacar.config;

import com.mzulfucelik.rentacar.aop.RestHandlerInterceptor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@NoArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private RestHandlerInterceptor restHandlerInterceptor;


    @Autowired
    public WebConfig(RestHandlerInterceptor restHandlerInterceptor) {
        this.restHandlerInterceptor = restHandlerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restHandlerInterceptor).addPathPatterns("/**");
    }
}
