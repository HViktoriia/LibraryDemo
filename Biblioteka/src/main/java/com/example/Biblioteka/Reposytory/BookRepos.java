package com.example.Biblioteka.Reposytory;

import com.example.Biblioteka.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepos extends JpaRepository<Book, Integer> {
}
