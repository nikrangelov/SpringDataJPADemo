package com.example.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 3/26/17.
 */

@Entity
@Table(name="authors")
public class Author {

    @Id
    @Column(name="author_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;

    @Column(name="f_name")
    String firstName;

    @Column(name="l_name")
    String lastName;


    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, mappedBy="author", cascade=CascadeType.ALL)
    List<Book> books = new ArrayList<Book>();


    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
