package com.ialiyldrm.LibraryApp.Repositories;

import com.ialiyldrm.LibraryApp.Entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library,Long> {

    List<Library> findById(Optional<Long> libraryId);
}
