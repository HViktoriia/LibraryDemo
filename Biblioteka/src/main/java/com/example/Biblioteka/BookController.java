package com.example.Biblioteka;

import com.example.Biblioteka.Book;
import com.example.Biblioteka.Reposytory.BookRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class BookController {
    private BookRepos bookRepos;
    @Autowired
    public BookController(BookRepos bookRepos){
        this.bookRepos = bookRepos;
    }

    @RequestMapping(value = "/dodajbook")
    public String dodajbook(){
        return "addbook";
    }

    @RequestMapping(value = "/addbook")
    public String DodajemyKsiazke (
            @RequestParam ("nazwa") String nazwa,
            @RequestParam ("Kategoria") String kategoria,
            @RequestParam ("Wydawca") String wydawca,
            @RequestParam("IloscStron") String iloscstron, Model model)
//            @RequestParam("Author") Author author,
            throws Exception {
       // System.out.println(nazwa);
        Book book = new Book(nazwa, kategoria, wydawca, iloscstron);
        bookRepos.save(book);
        System.out.println(book);
        model.addAttribute ("book", book);
        return "NoweDanyBook";
    }
    //@Autowired
    @RequestMapping("/wyswietli")
    //@ResponseBody
    public String wyswietli (Model model){
        for (Book book : bookRepos.findAll()){
            System.out.println(book);
        }
        model.addAttribute("book", bookRepos.findAll());
        //System.out.println(bookRepos.findAll());
        return "Wyswietli";
    }

    @RequestMapping("/deletebook")
    public String deletebook(@RequestParam("id") Integer id, Model model){
        bookRepos.deleteById(id);
        model.addAttribute("book", bookRepos.findAll());
        return "Wyswietli";
    }

    @RequestMapping("/findbook")
    public String findbook (@RequestParam("id") Integer id, Model model){
        model.addAttribute("book", bookRepos.findAllById(Collections.singleton(id)));
        return "Wyswietli";
    }
    @RequestMapping("/updatebook")
    public String updatebook(@RequestParam("id") Integer id,
                             @RequestParam("nazwa") String nazwa,
                             @RequestParam("Kategoria") String kategoria,
                             @RequestParam("Wydawca") String wydawca,
                             @RequestParam("IloscStron") String iloscstron, Model model) throws Exception{
        Book book = new Book(nazwa, kategoria, wydawca, iloscstron);
        bookRepos.save(book);
        model.addAttribute("book", book);
        return "Wyswietli";
    }
    @RequestMapping("/update")
    public String update(@RequestParam("id") Integer id, Model model) throws Exception{
        model.addAttribute("book", bookRepos.findAllById(Collections.singleton(id)));
        return "Update";
    }
}


