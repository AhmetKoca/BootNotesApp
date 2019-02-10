/*package com.akoca.BootNotesApp.config.database.primary;

import com.akoca.BootNotesApp.annotations.PrimaryDataSource;
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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "noteEntityManagerFactory" ,
        transactionManagerRef = "noteTransactionManager" ,
        basePackages = {"com.akoca.BootNotesApp.DBPrimary.repository"}
)
public class PrimaryDBConfig {

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    @PrimaryDataSource
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "noteEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean noteEntityManagerFactory(
            EntityManagerFactoryBuilder builder ,
            @Qualifier("dataSource") DataSource dataSource ) {

        return builder.dataSource(dataSource)
                .packages("com.akoca.BootNotesApp.DBPrimary.model")
                .persistenceUnit("DBPrimary")
                .build();
    }

    @Bean(name = "noteTransactionManager")
    @Primary
    public PlatformTransactionManager noteTransactionManager(
            @Qualifier("noteEntityManagerFactory")EntityManagerFactory noteEntityManagerFactory
            ) {

        return new JpaTransactionManager(noteEntityManagerFactory);
    }
}
*/