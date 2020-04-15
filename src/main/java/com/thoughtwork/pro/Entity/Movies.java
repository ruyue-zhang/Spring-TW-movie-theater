package com.thoughtwork.pro.Entity;

import org.springframework.data.annotation.Id;

public class Movies {
    @Id
    private int id;
    private String title;
    private String originTitle;
    private String year;
    private String image;
    private String directors;
    private String casts;
    private String genres;
    private String countries;
    private String languages;
    private String durations;
    private String pubdates;
    private String summary;
    private float  rating;

    public Movies() {
    }

    public Movies(int id, String title, String originTitle, String year, String image, String directors, String casts, String genres, String countries, String languages, String durations, String pubdates, String summary, float  rating) {
        this.id = id;
        this.title = title;
        this.originTitle = originTitle;
        this.year = year;
        this.image = image;
        this.directors = directors;
        this.casts = casts;
        this.genres = genres;
        this.countries = countries;
        this.languages = languages;
        this.durations = durations;
        this.pubdates = pubdates;
        this.summary = summary;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getDurations() {
        return durations;
    }

    public void setDurations(String durations) {
        this.durations = durations;
    }

    public String getPubdates() {
        return pubdates;
    }

    public void setPubdates(String pubdates) {
        this.pubdates = pubdates;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public float  getRating() {
        return rating;
    }

    public void setRating(float  rating) {
        this.rating = rating;
    }
}
