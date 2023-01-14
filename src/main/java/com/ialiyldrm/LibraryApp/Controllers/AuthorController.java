package com.ialiyldrm.LibraryApp.Controllers;


import com.ialiyldrm.LibraryApp.Entities.Author;
import com.ialiyldrm.LibraryApp.Exception.AuthorNotFoundException;
import com.ialiyldrm.LibraryApp.Responses.AuthorResponse;
import com.ialiyldrm.LibraryApp.Service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorResponse> getAllAuthors(){
        return authorService.getAllAuthors().stream().map(AuthorResponse::new).toList();
    }

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody Author newAuthor){
        Author author = authorService.saveOneAuthor(newAuthor);
        if(author != null)
            return  new ResponseEntity<>(HttpStatus.CREATED);
        return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{authorId}")
    public AuthorResponse getOneAuthor(@PathVariable Long authorId){
        Author author = authorService.getOneAuthorById(authorId);
        if( author == null){
            throw  new AuthorNotFoundException();
        }
        return new AuthorResponse(author);
    }

    @PutMapping("/{authorId}")
    public  ResponseEntity<Void> updateOneAuthor(@PathVariable Long authorId,@RequestBody Author newAuthor){
        Author author = authorService.updateOneAuthor(authorId,newAuthor);
        if( author != null){
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{authorId}")
    public  void deleteOneAuthor(@PathVariable Long authorId){
        authorService.deleteById(authorId);
    }
}
