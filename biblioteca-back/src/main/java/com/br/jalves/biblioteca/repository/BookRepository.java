package com.br.jalves.biblioteca.repository;

import com.br.jalves.biblioteca.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByName(String name);
}
