package org.example;

import org.example.configuration.ExternalServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties( { ExternalServiceProperties.class } )
public class DemoApplication {
    public static void main( String[] args ) {
        SpringApplication.run( DemoApplication.class );
    }
}