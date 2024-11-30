package org.example.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties( prefix = "demo.external.service" )
public class ExternalServiceProperties {

    private Boolean enabled;
    private String host;
    private String port;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled( Boolean enabled ) {
        this.enabled = enabled;
    }

    public String getHost() {
        return host;
    }

    public void setHost( String host ) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort( String port ) {
        this.port = port;
    }
}
