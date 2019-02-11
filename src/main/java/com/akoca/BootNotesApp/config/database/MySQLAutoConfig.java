/*package com.akoca.BootNotesApp.config.database;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@PropertySource("classpath:persistence.properties")
@PropertySource("classpath:hibernate.properties")
@ConditionalOnClass(DataSource.class)
public class MySQLAutoConfig {

    private final Environment environment;

    @Autowired
    public MySQLAutoConfig(Environment environment) {
        log.debug("My SQL Auto Config Created");
        this.environment = environment;
    }

    @Bean(name = "dataSource")
    @ConditionalOnProperty(name = "database.location" , havingValue = "memory")
    @ConditionalOnMissingBean
    public DataSource dataSourceMemory() {
        final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        driverManagerDataSource.setUrl("jdbc:h2:mem:notes_app;DB_CLOSE_DELAY=-1");
        driverManagerDataSource.setUsername("user");
        driverManagerDataSource.setPassword("00");

        return driverManagerDataSource;
    }

    @Bean(name = "dataSource")
    @ConditionalOnProperty(name = "database.location" , havingValue = "server")
    @ConditionalOnMissingBean
    public DataSource dataSourceServer() {
        final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("security-datasource.driver");
        driverManagerDataSource.setUrl(environment.getProperty("security-datasource.url"));
        driverManagerDataSource.setUsername(environment.getProperty("security-datasource.user"));
        driverManagerDataSource.setPassword(environment.getProperty("security-datasource.password"));

        return driverManagerDataSource;
    }

    @Bean
    @ConditionalOnBean(name = "dataSource")
    @ConditionalOnMissingBean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(value = "dataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        log.info("0");
        entityManagerFactory.setDataSource(dataSource);
        log.info("1");
        entityManagerFactory.setPackagesToScan("com.akoca.BootNotesApp.DBPrimary.model");
        log.info("2");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        log.info("3");
        if(null != jpaVendorProperties()) {
            entityManagerFactory.setJpaProperties(jpaVendorProperties());
        }
        log.info("4");

        return entityManagerFactory;
    }

    @Bean
    @ConditionalOnMissingBean(type = "JpaTransactionManager")
    public JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    @ConditionalOnResource(resources = "classpath:hibernate.properties")
    private final Properties jpaVendorProperties() {
        final Properties hibernateProperties = new Properties();

        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.dialect.storage_engine", environment.getProperty("hibernate.dialect.storage_engine"));
        hibernateProperties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql") != null ? environment.getProperty("hibernate.show_sql") : "false");

        return hibernateProperties;
    }
}
*/