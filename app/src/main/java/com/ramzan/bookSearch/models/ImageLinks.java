package com.ramzan.bookSearch.models;

import com.google.gson.annotations.SerializedName;

public class ImageLinks {

    @SerializedName("smallThumbnail")
    public String smallThumbnail;


    public String getSmallThumbnail(){
        return smallThumbnail;
    }
}
