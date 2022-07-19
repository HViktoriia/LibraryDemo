package com.example.Biblioteka.Controllers;

import com.example.Biblioteka.Classes.Author;
import com.example.Biblioteka.Classes.Series;
import com.example.Biblioteka.Reposytory.SeriesRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class SeriesController {
    private SeriesRepos seriesRepos;

    @Autowired
    public SeriesController(SeriesRepos seriesRepos) {
        this.seriesRepos = seriesRepos;
    }

    @RequestMapping(value = "/dodajserie")
    public String dodajserie() {
        return "addserie";
    }

    @RequestMapping(value = "/addserie")
    public String addserie(@RequestParam("NazwaSerii") String NazwaSerii,
                           @RequestParam("IloscKsiazek") Integer IloscKsiazek,
                           @RequestParam("ZwiazaneSerie") String ZwiazaneSerie, Model model)
            throws Exception {
        Series series = new Series(NazwaSerii, IloscKsiazek, ZwiazaneSerie);
        seriesRepos.save(series);
        System.out.println(series);
        model.addAttribute("series", series);
        return "NoweDanySeries";
    }

    @RequestMapping("/swyswietli")
    public String wyswietli(Model model) {
        model.addAttribute("book", seriesRepos.findAll());
        return "SWyswietli";
    }

    @RequestMapping("/deleteseries")
    public String deleteseries(@RequestParam("id") Integer id, Model model){
        seriesRepos.deleteById(id);
        model.addAttribute("series", seriesRepos.findAll());
        return "SWyswietli";
    }
    @RequestMapping("/updateserie")
    public String updateserie(@RequestParam("NazwaSerii") String NazwaSerii,
                              @RequestParam("IloscKsiazek") Integer IloscKsiazek,
                              @RequestParam("ZwiazaneSerie") String ZwiazaneSerie, Model model)
            throws Exception {
        Series series = new Series(NazwaSerii, IloscKsiazek, ZwiazaneSerie);
        seriesRepos.save(series);
        model.addAttribute("series", series);
        return "SWyswietli";
    }
    @RequestMapping("/updates")
    public String updates(@RequestParam("id") Integer id, Model model) throws Exception{
        model.addAttribute("series", seriesRepos.findAllById(Collections.singleton(id)));
        return "Updates";
    }
}
