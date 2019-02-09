package com.akoca.BootNotesApp.dto;


public class NewNoteDto {

    private String title;
    private String body;

    public NewNoteDto(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public NewNoteDto() {
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
}
