package org.example.configuration;

import org.example.behavior.DemoService;
import org.example.behavior.DemoServiceImpl;
import org.example.behavior.ExternalDemoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Bean
    public DemoService getDemoService( ExternalServiceProperties serviceProperties ) {
        if( serviceProperties.getEnabled() )
            return new ExternalDemoServiceImpl( serviceProperties );
        return new DemoServiceImpl();
    }

}
