package com.example.Biblioteka.Classes;


import com.example.Biblioteka.Book;

import javax.persistence.*;

@Entity
public class Wypozyczalnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdWypozyczalnik;
    private String Imie;
    private String Nazwisko;
    @OneToOne (cascade = CascadeType.ALL)
    private Book book;

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Wypozyczalnik(String imie, String nazwisko, Book book) {
        Imie = imie;
        Nazwisko = nazwisko;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Wypozyczalnik{" +
                "IdWypozyczalnik=" + IdWypozyczalnik +
                ", Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", book=" + book +
                '}';
    }
}
