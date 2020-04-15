package com.thoughtwork.pro.Entity;

import org.springframework.data.annotation.Id;

public class Reviews {
    @Id
    private int id;
    private int movieId;
    private String userName;
    private String title;
    private String content;
    private String avatar;

    public Reviews() {
    }

    public Reviews(int id, int movieId, String userName, String title, String content, String avatar) {
        this.id = id;
        this.movieId = movieId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
