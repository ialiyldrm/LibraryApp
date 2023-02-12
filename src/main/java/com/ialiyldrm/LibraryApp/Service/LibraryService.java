package com.ialiyldrm.LibraryApp.Service;

import com.ialiyldrm.LibraryApp.Entities.Book;
import com.ialiyldrm.LibraryApp.Entities.Library;
import com.ialiyldrm.LibraryApp.Entities.User;
import com.ialiyldrm.LibraryApp.Repositories.LibraryRepository;
import com.ialiyldrm.LibraryApp.Requests.BookUpdateRequest;
import com.ialiyldrm.LibraryApp.Requests.LibraryCreateRequest;
import com.ialiyldrm.LibraryApp.Requests.LibraryUpdateRequest;
import com.ialiyldrm.LibraryApp.Responses.LibraryResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private LibraryRepository libraryRepository;
    private UserService userService;

    public LibraryService(LibraryRepository libraryRepository, UserService userService) {
        this.libraryRepository = libraryRepository;
        this.userService = userService;
    }

    public List<LibraryResponse> getAllLibraries(Optional<Long> libraryId) {
        List<Library> list;
        if(libraryId.isPresent()){
            list = libraryRepository.findByLibraryId(libraryId.get());
        }else {
            list = libraryRepository.findAll();
        }
        return list.stream().map(LibraryResponse::new).collect(Collectors.toList());
    }

    public Library createOneLibrary(LibraryCreateRequest newLibRequest){
        User user = userService.getOneUserById(newLibRequest.getUser().getId());
        if(user == null)
            return  null;
        Library toSave= new Library();
        toSave.setLibraryName(newLibRequest.getLibraryName());
        toSave.setUser(newLibRequest.getUser());
        return libraryRepository.save(toSave);
    }

    public Library getOneLibraryById(Long libraryId) {
        return libraryRepository.findById(libraryId).orElse(null);
    }

    public Library updateOneLibraryById(Long libraryId, LibraryUpdateRequest libraryUpdate) {
        Optional<Library> library = libraryRepository.findById(libraryId);
        if(library.isPresent()){
            Library toUpdate = library.get();
            toUpdate.setLibraryName(libraryUpdate.getLibraryName());
            toUpdate.setUser(libraryUpdate.getUser());
            libraryRepository.save(toUpdate);
            return  toUpdate;
        }
        return  null;
    }
    public  void deleteOneLibraryById(Long libraryId){

        try{
            libraryRepository.deleteById(libraryId);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Book "+libraryId+" doesn't exist");
        }
    }

}
