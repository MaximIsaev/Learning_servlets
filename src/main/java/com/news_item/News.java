package com.news_item;

public class News {

    private static String guid;
    private static String title;
    private static String description;
    private static String author;
    private static String pubdate;
    private static String link;
    private static int id;

    public static void setGuid(String guid) {
        News.guid = guid;
    }

    public static void setTitle(String title) {
        News.title = title;
    }

    public static void setDescription(String description) {
        News.description = description;
    }

    public static void setAuthor(String author) {
        News.author = author;
    }

    public static void setPubdatee(String pubdate) {
        News.pubdate = pubdate;
    }

    public static void setId(int id) {
        News.id = id;
    }

    public static void setLink(String link) {
        News.link = link;
    }

    public static String getTitle() {
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
