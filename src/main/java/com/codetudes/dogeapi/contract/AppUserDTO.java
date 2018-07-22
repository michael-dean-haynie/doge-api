package com.codetudes.dogeapi.contract;

import java.util.Objects;

public class AppUserDTO {

    private long id;

    private String email;

    private String secret;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "AppUserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserDTO that = (AppUserDTO) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, secret);
    }
}