package com.akoca.BootNotesApp.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;

@EqualsAndHashCode
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title" , nullable = false , unique = true)
    private String title;

    @Column(name = "body" , nullable = false)
    private String body;

    @Column(name = "note_date" , nullable = false)
    private Timestamp noteDate;

    public Note(String title, String body, Timestamp noteDate) {
        this.title = title;
        this.body = body;
        this.noteDate = noteDate;
    }

    public Note() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Timestamp noteDate) {
        this.noteDate = noteDate;
    }
}
