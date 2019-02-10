package com.akoca.BootNotesApp.config.database;

import com.akoca.BootNotesApp.annotations.AuthenticationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
//@EnableTransactionManagement
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/*
    private DataSource securityDataSource;

    @Autowired
    @AuthenticationSource
    public SecurityConfig(DataSource securityDataSource) {
        this.securityDataSource = securityDataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }
*/
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .anyRequest().permitAll()
                //.antMatchers("/display-notes").hasRole("USER")
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();
    }
}