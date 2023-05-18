package com.Request;

import java.util.Objects;

public class LoginRequest {
    private String id;
    private String password;

    @Override
    public String
    toString() {
        return "LoginRequest{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginRequest that = (LoginRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }
    // getter/setter 方法省略
}
