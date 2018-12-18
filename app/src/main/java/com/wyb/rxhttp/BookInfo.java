package com.wyb.rxhttp;

public class BookInfo {

    private String book_date_public;

    private String book_anthor;

    private String book_brief;

    private String book_id;

    private String book_name;

    private String book_img_url;

    private String book_press;

    public String getBook_date_public() {
        return book_date_public;
    }

    public void setBook_date_public(String book_date_public) {
        this.book_date_public = book_date_public;
    }

    public String getBook_anthor() {
        return book_anthor;
    }

    public void setBook_anthor(String book_anthor) {
        this.book_anthor = book_anthor;
    }

    public String getBook_brief() {
        return book_brief;
    }

    public void setBook_brief(String book_brief) {
        this.book_brief = book_brief;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_img_url() {
        return book_img_url;
    }

    public void setBook_img_url(String book_img_url) {
        this.book_img_url = book_img_url;
    }

    public String getBook_press() {
        return book_press;
    }

    public void setBook_press(String book_press) {
        this.book_press = book_press;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "book_date_public='" + book_date_public + '\'' +
                ", book_anthor='" + book_anthor + '\'' +
                ", book_brief='" + book_brief + '\'' +
                ", book_id='" + book_id + '\'' +
                ", book_name='" + book_name + '\'' +
                ", book_img_url='" + book_img_url + '\'' +
                ", book_press='" + book_press + '\'' +
                '}';
    }
}
