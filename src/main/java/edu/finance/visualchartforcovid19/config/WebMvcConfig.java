package edu.finance.visualchartforcovid19.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/index.html").setViewName("/index");
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当第一次引用static文件夹时，需要重新打包
        registry.addResourceHandler("/**","/webjars/**").addResourceLocations("classpath:/static/","/webjars/");

    }
}
