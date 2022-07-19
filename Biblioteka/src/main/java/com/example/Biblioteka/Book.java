package com.example.Biblioteka;

import com.example.Biblioteka.Classes.Author;
import com.example.Biblioteka.Classes.Series;

import javax.persistence.*;

@Entity
@Table (name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Idbook;
    private String Nazwa;
    private String Kategoria;
    private String Wydawca;
    private String IloscStron;
//    @ManyToOne
//    private Series Serie;
    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String nazwa, String kategoria, String wydawca, String iloscStron) {
        Nazwa = nazwa;
        Kategoria = kategoria;
        Wydawca = wydawca;
        IloscStron = iloscStron;
    }

    public Book(String nazwa, String kategoria, String wydawca, String iloscStron, Author author) {
        Nazwa = nazwa;
        Kategoria = kategoria;
        Wydawca = wydawca;
        IloscStron = iloscStron;
        this.author = author;
    }

    public String getNazwa() { return Nazwa;}

    public void setNazwa(String nazwa) { Nazwa = nazwa; }

    public String getKategoria() { return Kategoria; }

    public void setKategoria(String kategoria) { Kategoria = kategoria;}

    public String getWydawca() { return Wydawca;}

    public void setWydawca(String wydawca) { Wydawca = wydawca;}

    public String getIloscStron() { return IloscStron;}

    public void setIloscStron(String iloscStron) { IloscStron = iloscStron;}

   public Author getAuthor() { return author;}

   public void setAuthor(Author author) {this.author = author;}

    @Override
    public String toString() {
        return "Book{" +
                "Idbook=" + Idbook +
                ", Nazwa='" + Nazwa + '\'' +
                ", Kategoria='" + Kategoria + '\'' +
                ", Wydawca='" + Wydawca + '\'' +
                ", Iloscstron=" + IloscStron +
                '}';
    }
}
