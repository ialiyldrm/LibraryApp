package com.ialiyldrm.LibraryApp.Repositories;

import com.ialiyldrm.LibraryApp.Entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library,Long> {
    List<Library> findByLibraryId(Long libraryId);
}
