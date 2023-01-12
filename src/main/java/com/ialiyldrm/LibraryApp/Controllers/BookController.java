package com.ialiyldrm.LibraryApp.Controllers;

import com.ialiyldrm.LibraryApp.Entities.Book;
import com.ialiyldrm.LibraryApp.Exception.BookNotFoundException;
import com.ialiyldrm.LibraryApp.Requests.BookCreateRequest;
import com.ialiyldrm.LibraryApp.Requests.BookUpdateRequest;
import com.ialiyldrm.LibraryApp.Responses.BookResponse;
import com.ialiyldrm.LibraryApp.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> getAllBooks(@RequestParam Optional<Long> userId){
        return  bookService.getAllBooks(userId);
    }

    @PostMapping
    public Book createOneBook(@RequestBody BookCreateRequest newBookRequest){
        return  bookService.createOneBook(newBookRequest);
    }

    @GetMapping("{bookId}")
    public BookResponse getOneBook(@PathVariable Long bookId){
        Book book = bookService.getOneBookById(bookId);
        if(book == null)
            throw  new BookNotFoundException();
        return new BookResponse(book);
    }

    @PutMapping("/{bookId}")
    public Book updateOnePost(@PathVariable Long bookId, @RequestBody BookUpdateRequest bookUpdate) {
        return bookService.updateOnePostById(bookId, bookUpdate);
    }

    @DeleteMapping("{bookId}")
    public void deleteOneBook(@PathVariable Long bookId){
        bookService.deleteOneBookById(bookId);
    }
}

