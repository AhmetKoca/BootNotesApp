package com.akoca.BootNotesApp.service.impl;

import com.akoca.BootNotesApp.exception.NoteNotFoundException;
import com.akoca.BootNotesApp.DBPrimary.model.Note;
import com.akoca.BootNotesApp.DBPrimary.repository.NoteRepository;
import com.akoca.BootNotesApp.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).orElseThrow(NoteNotFoundException::new);
    }

    @Override
    public Note findByTitle(String title) {

        log.debug("Calling: " , this.getClass().getEnclosingMethod());
        return noteRepository.findByTitle(title);
    }

    @Override
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note update(Note note) {
        noteRepository.findById(note.getId())
                .orElseThrow(NoteNotFoundException::new);

        return noteRepository.save(note);
    }

    @Override
    public void delete(Long id) {
        noteRepository.findById(id)
                .orElseThrow(NoteNotFoundException::new);

        noteRepository.deleteById(id);
    }
}
