package com.ialiyldrm.LibraryApp.Repositories;

import com.ialiyldrm.LibraryApp.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
