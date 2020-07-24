package com.ramzan.bookSearch.models;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private String authors;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("smallThumbnail")
    private String smallThumbnail;
    @SerializedName("pageCount")
    private String pageCount;
    @SerializedName("averageRating")
    private String averageRating;


    @SerializedName("volumeInfo")
    public VolumeInfo volumeInfo;



    public Book(String title, String authors, String publishedDate, String smallThumbnail, String pageCount, String averageRating, String infoLink) {
        this.title = title;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.smallThumbnail = smallThumbnail;
        this.pageCount = pageCount;
        this.averageRating = averageRating;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String getAverageRating() {
        return averageRating;
    }


}

