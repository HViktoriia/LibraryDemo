package com.example.Biblioteka.Reposytory;

import com.example.Biblioteka.Classes.Wypozyczalnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WypozyczalnikRepos extends JpaRepository<Wypozyczalnik, Integer> {
}
