package com.Request;

import java.util.Objects;

public class objectRequest {
    String status;
    Object object;

    public objectRequest(String status, Object object) {
        this.status = status;
        this.object = object;
    }
    public objectRequest(int status, Object object) {
        this.status = String.valueOf(status);
        this.object = object;
    }
    @Override
    public String toString() {
        return "objectRequest{" +
                "status='" + status + '\'' +
                ", object=" + object +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        objectRequest that = (objectRequest) o;
        return Objects.equals(status, that.status) && Objects.equals(object, that.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, object);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
