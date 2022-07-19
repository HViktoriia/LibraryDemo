package com.example.Biblioteka.Reposytory;

import com.example.Biblioteka.Classes.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepos extends JpaRepository<Author, Integer> {
}
