package com.codetudes.dogeapi.contract;

import java.util.Objects;

public class WordDTO {
    private Long id;

    private Long appUserId;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WordDTO{" +
                "id=" + id +
                ", appUserId=" + appUserId +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordDTO wordDTO = (WordDTO) o;
        return Objects.equals(id, wordDTO.id) &&
                Objects.equals(appUserId, wordDTO.appUserId) &&
                Objects.equals(content, wordDTO.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, appUserId, content);
    }
}
