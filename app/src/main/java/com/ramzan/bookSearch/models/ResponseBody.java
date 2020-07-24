package com.ramzan.bookSearch.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBody {

    @SerializedName("kind")
    private String kind;
    @SerializedName("totalItems")
    private int totalItems;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("items")
    public List<Book> bookList;
}
