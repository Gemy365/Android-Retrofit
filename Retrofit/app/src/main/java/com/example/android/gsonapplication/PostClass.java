package com.example.android.gsonapplication;

import com.google.gson.annotations.SerializedName;

// PostClass to fetch data of json from URL: 'https://jsonplaceholder.typicode.com/posts'.
public class PostClass {

    private int userId;

    private int id;

    private String title;

    @SerializedName("body")
    private String text;


    public PostClass(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
