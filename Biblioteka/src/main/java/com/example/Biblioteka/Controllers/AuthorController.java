package com.example.Biblioteka.Controllers;

import com.example.Biblioteka.Classes.Author;
import com.example.Biblioteka.Reposytory.AuthorRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

//@ControllerAdvice

@Controller
public class AuthorController {
    private AuthorRepos authorRepos;
    @Autowired
    public AuthorController (AuthorRepos authorRepos){this.authorRepos = authorRepos;}
    @RequestMapping(value = "/dodajauthora")
    public String dodajauthora(){return "NowyAuthor";}

    @RequestMapping(value = "addauthor")
    public String addauthor (@RequestParam ("Name") String Name,
                             @RequestParam("Surname") String Surname, Model model) throws Exception{
        Author author = new Author(Name, Surname);
        authorRepos.save(author);
        System.out.println(author);
        model.addAttribute("author", author);
        return "NoweDanyAuthor";
    }
    @RequestMapping("/pokazauthora")
    public String pokazauthora (Model model){
        model.addAttribute("author", authorRepos.findAll());
        return "AWyswietli";
    }
    @RequestMapping("/deleteauthor")
    public String deleteauthor(@RequestParam("id") Integer id, Model model){
        authorRepos.deleteById(id);
        model.addAttribute("author", authorRepos.findAll());
        return "AWyswietli";
    }
    @RequestMapping("/findauthor")
    public String findauthor (@RequestParam("id") Integer id, Model model){
        model.addAttribute("author", authorRepos.findById(id));
        return "AWyswietli";
    }
    @RequestMapping("/udateauthor")
    public String updateauthor(@RequestParam("id") Integer id,
                               @RequestParam("Name") String Name,
                               @RequestParam("Surname") String Surname, Model model) throws Exception{
        Author author = new Author(Name, Surname);
        authorRepos.save(author);
        model.addAttribute("author", author);
        return "AWyswietli";
    }

    @RequestMapping("/apdateau")
    public String updateau (@RequestParam("id") Integer id, Model model) throws Exception{
        model.addAttribute("author", authorRepos.findById(id));
        return "Updateau";
    }

}
