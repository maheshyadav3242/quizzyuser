package com.example.quizzy;

public class Categorymodel {
    private String imageurl;
    private String title;


    public Categorymodel(String imageurl, String title) {
        this.imageurl = imageurl;
        this.title = title;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
