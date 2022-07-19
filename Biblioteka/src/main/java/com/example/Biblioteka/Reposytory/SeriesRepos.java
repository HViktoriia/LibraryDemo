package com.example.Biblioteka.Reposytory;

import com.example.Biblioteka.Classes.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepos extends JpaRepository <Series, Integer> {
}
