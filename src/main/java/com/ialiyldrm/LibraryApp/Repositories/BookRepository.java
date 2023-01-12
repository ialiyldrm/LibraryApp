package com.ialiyldrm.LibraryApp.Repositories;

import com.ialiyldrm.LibraryApp.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByUserId(Long userId);
}
