package com.neagumihai.proiectpibddata.decorators;

public class StatusWraper<T> {
    private T status;

    public StatusWraper() {

    }
    public StatusWraper(T status) {
        this.status = status;
    }

    public T isStatus() {
        return status;
    }

    public void setStatus(T status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status.toString();
    }
}
