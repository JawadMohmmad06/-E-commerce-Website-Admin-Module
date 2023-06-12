package com.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull

    @Column(name = "bookname")
    private String bookname;
    @NotNull

    @Column(name = "bookcondition")
    private String bookcondition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookcondition() {
        return bookcondition;
    }

    public void setBookcondition(String bookcondition) {
        this.bookcondition = bookcondition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBookdetails() {
        return bookdetails;
    }

    public void setBookdetails(String bookdetails) {
        this.bookdetails = bookdetails;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public Long getSellerid() {
        return sellerid;
    }

    public void setSellerid(Long sellerid) {
        this.sellerid = sellerid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @NotNull

    @Column(name = "category")
    private String category;
    @NotNull

    @Column(name = "bookdetails")
    private String bookdetails;
    @NotNull

    @Column(name = "authorname")
    private String authorname;
    @NotNull

    @Column(name = "sellerid")
    private Long sellerid;
    @NotNull

    @Column(name = "price")
    private Double price;

}
