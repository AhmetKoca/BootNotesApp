/*package com.akoca.BootNotesApp.config.database.security;

import com.akoca.BootNotesApp.annotations.AuthenticationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "securityEntityManagerFactory" ,
        transactionManagerRef = "securityTransactionManager" ,
        basePackages = {"com.akoca.BootNotesApp.DBSecurity.repository"}
)
public class SecurityDBConfig {


    @Bean(name = "securityDataSource")
    @AuthenticationSource
    @ConfigurationProperties(prefix = "spring.security-datasource")
    public DataSource getSecurityDataSource() {

        return DataSourceBuilder.create().build();
    }

    @Bean(name = "securityEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean securityEntityManagerFactory(
            EntityManagerFactoryBuilder builder ,
            @Qualifier("securityDataSource") DataSource dataSource ) {

        return builder.dataSource(dataSource)
                .packages("com.akoca.BootNotesApp.DBSecurity.model")
                .persistenceUnit("DBSecurity")
                .build();
    }

    @Bean(name = "securityTransactionManager")
    @Primary
    public PlatformTransactionManager securityTransactionManager(
            @Qualifier("securityEntityManagerFactory") EntityManagerFactory securityEntityManagerFactory
    ) {

        return new JpaTransactionManager(securityEntityManagerFactory);
    }
}
*/