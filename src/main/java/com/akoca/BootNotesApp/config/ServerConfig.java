package com.akoca.BootNotesApp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Configuration
@PropertySource("classpath:server.properties")
@ConfigurationProperties(prefix = "server")
public class ServerConfig {

    private String contextPath;

    @Min(1025)
    @Max(65536)
    private int port;

    private List<Integer> alternativePorts;

    public ServerConfig(String contextPath, int port, List<Integer> alternativePorts) {
        this.contextPath = contextPath;
        this.port = port;
        this.alternativePorts = alternativePorts;
    }

    public ServerConfig() {
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<Integer> getAlternativePorts() {
        return alternativePorts;
    }

    public void setAlternativePorts(List<Integer> alternativePorts) {
        this.alternativePorts = alternativePorts;
    }
}
