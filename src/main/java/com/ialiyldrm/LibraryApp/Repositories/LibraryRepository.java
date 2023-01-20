package com.ialiyldrm.LibraryApp.Repositories;

import com.ialiyldrm.LibraryApp.Entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Long> {
}
