package com.akoca.BootNotesApp.config;

import com.akoca.BootNotesApp.annotations.PrimaryDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @PrimaryDataSource
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}
