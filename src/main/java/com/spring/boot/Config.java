package com.spring.boot;

import com.spring.boot.view_resolvers.DocxView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

import javax.sql.DataSource;

@Configuration
//@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {
//
//    @Bean
//    public XmlViewResolver xmlViewResolver() {
//        XmlViewResolver xmlViewResolver = new XmlViewResolver();
//        xmlViewResolver.setOrder(1);
//        return xmlViewResolver;
//    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    @Description("Resolve path to jsp storage")
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setViewClass(JstlView.class);
        return internalResourceViewResolver;
    }
//
//    public UrlBasedViewResolver setupUrlBasedViewResolver(){
//        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
//        urlBasedViewResolver.setPrefix("/WEB-INF/pages/");
//        urlBasedViewResolver.setSuffix(".docx");
//        urlBasedViewResolver.setViewClass(DocxView.class);
//        urlBasedViewResolver.setOrder(1);
//        return urlBasedViewResolver;
//    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("my-schema.sql")
                .addScript("my-test-data.sql")
                .build();
    }

}
