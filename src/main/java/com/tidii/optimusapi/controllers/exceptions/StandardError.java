package com.tidii.optimusapi.controllers.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long timeStammp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(Long timeStammp, Integer status, String error, String message, String path) {
        this.timeStammp = timeStammp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimeStammp() {
        return timeStammp;
    }

    public void setTimeStammp(Long timeStammp) {
        this.timeStammp = timeStammp;
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
