package com.example.genpessosapi.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

public class StandarError implements Serializable {

    private static final long serialVerionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timetamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandarError(){

    }

    public StandarError(Instant timetamp, Integer status, String error, String message, String path) {
        super();
        this.timetamp = timetamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimetamp() {
        return timetamp;
    }

    public void setTimetamp(Instant timetamp) {
        this.timetamp = timetamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
