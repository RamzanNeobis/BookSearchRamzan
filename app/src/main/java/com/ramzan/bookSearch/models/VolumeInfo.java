package com.ramzan.bookSearch.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumeInfo {

    @SerializedName("title")
    public String title;

    @SerializedName("authors")
    public List<String> authors;

    @SerializedName("averageRating")
    public String averageRating;

    @SerializedName("previewLink")
    public  String previewLink;

    @SerializedName("publishedDate")
    public String publishedDate;

    @SerializedName("pageCount")
    public String pageCount;






    @SerializedName("imageLinks")
    public ImageLinks imageLinks;


    public  String getPreviewLink(){
        return previewLink;
    }






}
