package com.akoca.BootNotesApp.exception.handler;

import com.akoca.BootNotesApp.exception.NoteIdMismatchException;
import com.akoca.BootNotesApp.exception.NoteNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class NotesExceptionHandler extends ResponseEntityExceptionHandler {

    public NotesExceptionHandler() {
        super();
    }

    @ExceptionHandler(NoteNotFoundException.class)
    protected ResponseEntity<Object> handleNoteNotFound(Exception exception , WebRequest request) {
        return handleExceptionInternal(exception , "Note does not exist" , new HttpHeaders() ,
                HttpStatus.NOT_FOUND , request);
    }

    @ExceptionHandler(
            {
                    NoteIdMismatchException.class ,
                    ConstraintViolationException.class ,
                    DataIntegrityViolationException.class ,
            }
    )
    public ResponseEntity<Object> handleBadRequest(Exception exception , WebRequest request) {
        return handleExceptionInternal(exception , exception.getLocalizedMessage() , new HttpHeaders() ,
                HttpStatus.BAD_REQUEST , request);
    }
}