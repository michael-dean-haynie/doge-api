package com.codetudes.dogoapi.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    private long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "secret", nullable = false)
    private String secret;

    @Column(name = "created", nullable = false)
    private String created;

    @Column(name = "updated", nullable = false)
    private String updated;

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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", secret='" + secret + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id &&
                Objects.equals(email, appUser.email) &&
                Objects.equals(secret, appUser.secret) &&
                Objects.equals(created, appUser.created) &&
                Objects.equals(updated, appUser.updated);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, secret, created, updated);
    }
}
