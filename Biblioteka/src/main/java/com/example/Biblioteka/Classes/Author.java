package com.example.Biblioteka.Classes;

import com.example.Biblioteka.Book;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer IdAuthor;
    private String Name;
    private String Surname;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Series> series;

    public Author(String name, String surname, List<Book> books, List<Series> series) {
        Name = name;
        Surname = surname;
        this.books = books;
        this.series = series;
    }


    public Author(String name, String surname, List<Book> books) {
        Name = name;
        Surname = surname;
        this.books = books;
    }

    public Author(String name, String surname) {
        Name = name;
        Surname = surname;
    }

    public Integer getIdAuthor() {
        return IdAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        IdAuthor = idAuthor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public List<Book> getBooks() { return books;}

    public void setBooks(List<Book> books) { this.books = books;}

    public List<Series> getSeries() { return series;}

    public void setSeries(List<Series> series) { this.series = series;}

    @Override
    public String toString() {
        return "Author{" +
                "IdAuthor=" + IdAuthor +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }
}
