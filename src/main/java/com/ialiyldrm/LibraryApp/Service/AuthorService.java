package com.ialiyldrm.LibraryApp.Service;

import com.ialiyldrm.LibraryApp.Entities.Author;
import com.ialiyldrm.LibraryApp.Repositories.AuthorRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author saveOneAuthor(Author newAuthor) {
        return  authorRepository.save(newAuthor);
    }

    public Author getOneAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }


    public Author updateOneAuthor(Long authorId, Author newAuthor) {
        Optional<Author> author = authorRepository.findById(authorId);
        if(author.isPresent()) {
            Author foundAuthor = author.get();
            foundAuthor.setAuthorName(newAuthor.getAuthorName());
            foundAuthor.setAbout(newAuthor.getAbout());
            authorRepository.save(foundAuthor);
            return foundAuthor;
        }else
            return null;
    }

    public  void  deleteById(Long authorId){

        try {
            authorRepository.deleteById(authorId);
        } catch (EmptyResultDataAccessException e){//author zaten yok, db'den empty result gelmiş
            System.out.println("Author "+authorId+" doesn't exist");
        }
    }

}
