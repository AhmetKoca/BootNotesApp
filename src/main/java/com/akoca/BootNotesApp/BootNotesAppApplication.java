package com.akoca.BootNotesApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@EntityScan("com.akoca.BootNotesApp.model")
@EnableJpaRepositories("com.akoca.BootNotesApp.repository")
@SpringBootApplication
public class BootNotesAppApplication {

    public static void main(String[] args) {

        log.info("Starting");
        SpringApplication.run(BootNotesAppApplication.class, args);
    }

}

