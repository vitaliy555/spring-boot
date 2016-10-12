package com.spring.boot;

import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.spring.boot.view_resolvers.PdfView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    public XmlViewResolver xmlViewResolver(){
        XmlViewResolver xmlViewResolver = new XmlViewResolver();
        xmlViewResolver.setOrder(1);
        return xmlViewResolver;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setOrder(2);
        return internalResourceViewResolver;
    }

}
