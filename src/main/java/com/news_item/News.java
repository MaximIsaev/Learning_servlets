package com.news_item;

public class News {


    private static String title;
    private static String description;
    private static String author;
    private static String pubdate;
    private static int id;


    public void setTitle(String title) {
        News.title = title;
    }

    public void setDescription(String description) {
        News.description = description;
    }

    public void setAuthor(String author) {
        News.author = author;
    }

    public void setPubdatee(String pubdate) {
        News.pubdate = pubdate;
    }

    public void setId(int id) {
        News.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getPubdate() {
        return pubdate;
    }

    public int getId() {
        return id;
    }


}
