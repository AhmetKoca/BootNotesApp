package com.akoca.BootNotesApp.repository;

import com.akoca.BootNotesApp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note , Long> {
    Note findByTitle(String title);
}
