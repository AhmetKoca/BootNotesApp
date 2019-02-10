package com.akoca.BootNotesApp.controller;

import com.akoca.BootNotesApp.dto.NewNoteDto;
import com.akoca.BootNotesApp.DBPrimary.model.Note;
import com.akoca.BootNotesApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> findAll() {
        return noteService.findAll();
    }

    @GetMapping("/title/{noteTitle}")
    public Note findByTitle(@PathVariable String noteTitle) {
        return noteService.findByTitle(noteTitle);
    }

    @GetMapping("/{id}")
    public Note findById(@PathVariable Long id) {
        return noteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody NewNoteDto newNoteDto) {
        Note note = new Note(newNoteDto.getTitle() , newNoteDto.getBody() , new Timestamp(System.currentTimeMillis()));
        return noteService.create(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteService.delete(id);
    }

    @PutMapping
    public Note update(@RequestBody Note note) {
        return noteService.update(note);
    }
}