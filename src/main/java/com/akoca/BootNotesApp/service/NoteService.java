package com.akoca.BootNotesApp.service;

import com.akoca.BootNotesApp.DBPrimary.model.Note;

import java.util.List;

public interface NoteService {
    public List<Note> findAll();

    public Note findById(Long id);

    public Note findByTitle(String title);

    public Note create(Note note);

    public Note update(Note note);

    public void delete(Long id);
}
