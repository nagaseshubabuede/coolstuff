package com.example.springboottesting.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The class helps to normalize error response.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage implements Serializable {

    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;
    private String trace;
    private String path;


    public ErrorMessage(LocalDateTime timeStamp, int status, String error, String message, String trace, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.trace = trace;
        this.path = path;
    }

    /**
     * Note Gettera and Setters are required ... used by Spring Boot while designing ResponseEntity
     */

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
