package com.akoca.BootNotesApp.controller;

import com.akoca.BootNotesApp.DBPrimary.model.Note;
import com.akoca.BootNotesApp.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    private NoteService noteService;

    @Autowired
    public MainController(NoteService noteService) {
        this.noteService = noteService;
    }

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

        int i = 1;
        for(Note note : noteService.findAll()) {
            model.addAttribute("note" + i , note);
            ++i;
        }

        /*model.addAttribute("note1" , "sdddddddddddddddddddddddddd");
        model.addAttribute("note2" , "sddddddhgghhhhhhhhhhhhhhhhhhdddddddd");
        model.addAttribute("note3" , "sddddlkkkkkkkkkkkkkkkkkkkkdd");
        model.addAttribute("note4" , "sddddaaaaaaaaaaaaaaaaaaaaad");
        model.addAttribute("note5" , "sddddddppppppppppppppppppppd");*/

        log.info("calling list");

        return "list-notes.html";
    }
}
