package com.example.feginclientdemo;

import java.util.List;

public class Response <T>
{
    public String status;
    public String message;
    private T body;
    List<Error> errorList;

    public String getStatus() {
        return status;
    }

    public Response<T> setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getBody() {
        return body;
    }

    public Response<T> setBody(T body) {
        this.body = body;
        return this;
    }

    public List<Error> getErrorList() {
        return errorList;
    }

    public Response<T> setErrorList(List<Error> errorList) {
        this.errorList = errorList;
        return this;
    }
}
