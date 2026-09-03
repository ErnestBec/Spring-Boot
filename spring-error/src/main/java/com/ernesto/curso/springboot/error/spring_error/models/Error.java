package com.ernesto.curso.springboot.error.spring_error.models;

import java.util.Date;

public class Error {
    private String message;
    private String error;
    private int satus;
    private Date date;

     
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public int getSatus() {
        return satus;
    }
    public void setSatus(int satus) {
        this.satus = satus;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    
}
