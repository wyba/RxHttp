package com.wyb.rxhttp;

public class BookRequest {

    private String book_name;
    private String book_anthor;
    private String book_keyword;
    private String book_class_number;
    private String book_ISBN;
    private String book_press;
    private String book_collection;
    private String book_type_id;
    private String book_borw_id;
    private String start_time;
    private String end_time;

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_anthor() {
        return book_anthor;
    }

    public void setBook_anthor(String book_anthor) {
        this.book_anthor = book_anthor;
    }

    public String getBook_keyword() {
        return book_keyword;
    }

    public void setBook_keyword(String book_keyword) {
        this.book_keyword = book_keyword;
    }

    public String getBook_class_number() {
        return book_class_number;
    }

    public void setBook_class_number(String book_class_number) {
        this.book_class_number = book_class_number;
    }

    public String getBook_ISBN() {
        return book_ISBN;
    }

    public void setBook_ISBN(String book_ISBN) {
        this.book_ISBN = book_ISBN;
    }

    public String getBook_press() {
        return book_press;
    }

    public void setBook_press(String book_press) {
        this.book_press = book_press;
    }

    public String getBook_collection() {
        return book_collection;
    }

    public void setBook_collection(String book_collection) {
        this.book_collection = book_collection;
    }

    public String getBook_type_id() {
        return book_type_id;
    }

    public void setBook_type_id(String book_type_id) {
        this.book_type_id = book_type_id;
    }

    public String getBook_borw_id() {
        return book_borw_id;
    }

    public void setBook_borw_id(String book_borw_id) {
        this.book_borw_id = book_borw_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "book_name='" + book_name + '\'' +
                ", book_anthor='" + book_anthor + '\'' +
                ", book_keyword='" + book_keyword + '\'' +
                ", book_class_number='" + book_class_number + '\'' +
                ", book_ISBN='" + book_ISBN + '\'' +
                ", book_press='" + book_press + '\'' +
                ", book_collection='" + book_collection + '\'' +
                ", book_type_id='" + book_type_id + '\'' +
                ", book_borw_id='" + book_borw_id + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}
