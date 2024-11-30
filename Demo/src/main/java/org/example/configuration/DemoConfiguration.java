package org.example.configuration;

import org.example.logic.DemoService;
import org.example.logic.DemoServiceImpl;
import org.example.logic.HttpSourceServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Bean
    @ConditionalOnProperty( value = "demo.external.service.enable", havingValue = "false" )
    public DemoService getLocalDemoService() {
        return new DemoServiceImpl();
    }

    @Bean
    @ConditionalOnProperty( value = "demo.external.service.enable", havingValue = "true" )
    public DemoService getExternalDemoService() {
        return new HttpSourceServiceImpl();
    }

}
