package com.akoca.BootNotesApp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
@Slf4j
public class MainController {

    @Value("${spring.application.name}")
    String applicationName;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("appName" , applicationName);
        model.addAttribute("name" , "Akoca");
        model.addAttribute("dateNow" , new Date(System.currentTimeMillis()));

        log.info("Calling home");

        //return "test";
        return "home.html";
    }

    @PostMapping("/display-notes")
    public String displayNotes(Model model) {
        model.addAttribute("note1" , "sdddddddddddddddddddddddddd");
        model.addAttribute("note2" , "sddddddhgghhhhhhhhhhhhhhhhhhdddddddd");
        model.addAttribute("note3" , "sddddlkkkkkkkkkkkkkkkkkkkkdd");
        model.addAttribute("note4" , "sddddaaaaaaaaaaaaaaaaaaaaad");
        model.addAttribute("note5" , "sddddddppppppppppppppppppppd");

        log.info("calling list");

        return "list-notes.html";
    }
}
