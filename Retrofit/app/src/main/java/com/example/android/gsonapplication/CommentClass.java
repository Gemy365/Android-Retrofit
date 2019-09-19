package com.example.android.gsonapplication;

import com.google.gson.annotations.SerializedName;

// CommentClass to fetch data of json from URL: 'https://jsonplaceholder.typicode.com/posts/1/comment'.
public class CommentClass {

    private String first_name;

    private String last_name;

    private String id;

    private String age;

    private String email;

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
