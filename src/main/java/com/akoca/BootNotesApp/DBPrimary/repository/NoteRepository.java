package com.akoca.BootNotesApp.DBPrimary.repository;

import com.akoca.BootNotesApp.DBPrimary.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note , Long> {
    Note findByTitle(String title);
}
