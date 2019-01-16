package com.ustc.reed.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "book")
public class Book {
    private String author;
    private Integer price;
   //set

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //get

    public String getAuthor() {
        return author;
    }
    public int getPrice() {
        return price;
    }
}
