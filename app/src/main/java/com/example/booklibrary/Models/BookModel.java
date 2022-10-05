package com.example.booklibrary.Models;

public class BookModel {

    String image;
    String bookName;
    String url;

    public BookModel(String image, String bookName, String url) {
        this.image = image;
        this.bookName = bookName;
        this.url = url;
    }
    public  BookModel(){

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
