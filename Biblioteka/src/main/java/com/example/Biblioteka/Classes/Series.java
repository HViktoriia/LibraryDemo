package com.example.Biblioteka.Classes;

import com.example.Biblioteka.Book;

import javax.persistence.*;
import java.util.List;

@Entity
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdSeries;
    private String NazwaSerii;
    private Integer IloscKsiazek;
    private String ZwiazaneSerie;
    @OneToMany
    private List<Book> books;

    public Series(String nazwaSerii, Integer iloscKsiazek, String zwiazaneSerie, List<Book> books) {
        NazwaSerii = nazwaSerii;
        IloscKsiazek = iloscKsiazek;
        ZwiazaneSerie = zwiazaneSerie;
        this.books = books;
    }

    public Series(String nazwaSerii, Integer iloscKsiazek, String zwiazaneSerie) {
        NazwaSerii = nazwaSerii;
        IloscKsiazek = iloscKsiazek;
        ZwiazaneSerie = zwiazaneSerie;
    }

    public String getNazwaSerii() { return NazwaSerii;}

    public void setNazwaSerii(String nazwaSerii) { NazwaSerii = nazwaSerii;}

    public Integer getIloscKsiazek() { return IloscKsiazek;}

    public void setIloscKsiazek(Integer iloscKsiazek) { IloscKsiazek = iloscKsiazek;}

    public String getZwiazaneSerie() { return ZwiazaneSerie;}

    public void setZwiazaneSerie(String zwiazaneSerie) { ZwiazaneSerie = zwiazaneSerie;}

    public List<Book> getBooks() { return books;}

    public void setBooks(List<Book> books) { this.books = books;}

    @Override
    public String toString() {
        return "Series{" +
                "IdSeries=" + IdSeries +
                ", NazwaSerii='" + NazwaSerii + '\'' +
                ", IloscKsiazek=" + IloscKsiazek +
                ", ZwiazaneSerie='" + ZwiazaneSerie + '\'' +
                '}';
    }

}
