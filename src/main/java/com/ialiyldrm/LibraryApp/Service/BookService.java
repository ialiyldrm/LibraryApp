package com.ialiyldrm.LibraryApp.Service;

import com.ialiyldrm.LibraryApp.Entities.Book;
import com.ialiyldrm.LibraryApp.Entities.User;
import com.ialiyldrm.LibraryApp.Repositories.BookRepository;
import com.ialiyldrm.LibraryApp.Requests.BookCreateRequest;
import com.ialiyldrm.LibraryApp.Requests.BookUpdateRequest;
import com.ialiyldrm.LibraryApp.Responses.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private UserService userService;

    public BookService(BookRepository bookRepository, UserService userService) {
        this.bookRepository = bookRepository;
        this.userService = userService;
    }

    public List<BookResponse> getAllBooks(Optional<Long> userId) {
        List<Book> list;
        if(userId.isPresent()){
            list = bookRepository.findByUserId(userId.get());
        }else{
            list = bookRepository.findAll();
        }
        return  list.stream().map(b ->{
            return new BookResponse(b);}).collect(Collectors.toList());
    }

    public Book createOneBook(BookCreateRequest newBookRequest) {
        User user = userService.getOneUserById(newBookRequest.getUserId());
        if(user == null)
            return  null;
        Book toSave = new Book();
        toSave.setId(newBookRequest.getId());
        toSave.setName(newBookRequest.getName());
        toSave.setCommit(newBookRequest.getCommit());
        toSave.setEdition(newBookRequest.getEdition());
        toSave.setAddDate(newBookRequest.getAddDate());
        toSave.setReadDate(newBookRequest.getReadDate());
        toSave.setRead(newBookRequest.isRead());
        toSave.setUser(user);
        return  bookRepository.save(toSave);
    }

    public Book getOneBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);

    }

    public Book updateOnePostById(Long bookId, BookUpdateRequest bookUpdateRequest) {
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            Book toUpdate = book.get();
            toUpdate.setName(bookUpdateRequest.getName());
            toUpdate.setCommit(bookUpdateRequest.getCommit());
            toUpdate.setEdition(bookUpdateRequest.getEdition());
            toUpdate.setAddDate(bookUpdateRequest.getAddDate());
            toUpdate.setReadDate(bookUpdateRequest.getReadDate());
            toUpdate.setRead(bookUpdateRequest.isRead());
            bookRepository.save(toUpdate);
            return  toUpdate;
        }
        return  null;
    }

    public  void deleteOneBookById(Long bookId){
        bookRepository.deleteById(bookId);
    }
}
