package com.spring.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
public class Config {
//
//    @Bean
//    public XmlViewResolver xmlViewResolver() {
//        XmlViewResolver xmlViewResolver = new XmlViewResolver();
//        xmlViewResolver.setOrder(1);
//        return xmlViewResolver;
//    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

}
