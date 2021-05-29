package com.zhixin.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

/**
 * @author yutiantang
 * @create 2021/5/30 00:00
 */
@Configuration
public class WebConfig extends WebMvcAutoConfiguration {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.of(1, DataUnit.GIGABYTES));
        factory.setMaxRequestSize(DataSize.of(2, DataUnit.GIGABYTES));

        return factory.createMultipartConfig();
    }
}
