package com.example.domain;

import javax.persistence.*;

/**
 * Created by nik on 3/26/17.
 */
@Entity
@Table(name="books")
public class Book {

    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name="title")
    String title;


    @ManyToOne
    @JoinColumn(name="author_id")
    Author author;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
