package com.yxw.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @Author: yxw
 * @Date: 2018/12/22 20:01
 * @Description:
 * @Version 1.0
 */
@Configuration
public class ExceptionConf {
    @Bean
    public SimpleMappingExceptionResolver resolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/notRole");
        resolver.setExceptionMappings(properties);
        return resolver;
    }

}
