package com.ialiyldrm.LibraryApp.Controllers;

import com.ialiyldrm.LibraryApp.Entities.Library;
import com.ialiyldrm.LibraryApp.Exception.LibraryNotFoundException;
import com.ialiyldrm.LibraryApp.Requests.LibraryCreateRequest;
import com.ialiyldrm.LibraryApp.Requests.LibraryUpdateRequest;
import com.ialiyldrm.LibraryApp.Responses.LibraryResponse;
import com.ialiyldrm.LibraryApp.Service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<LibraryResponse> getAllLibraries(@RequestParam Optional<Long> libraryId) {
        return libraryService.getAllLibraries(libraryId);
    }

    @PostMapping("/{libraryId}")
    public Library createOneLibrary(@RequestBody LibraryCreateRequest newLibraryReq){
        return  libraryService.createOneLibrary(newLibraryReq);
    }

    @GetMapping("/{libraryId}")
    public LibraryResponse getOneLibrary(@PathVariable Long libraryId){
        Library library = libraryService.getOneLibraryById(libraryId);
        if(library == null)
            throw new LibraryNotFoundException();
        return new LibraryResponse(library);
    }

    @PutMapping("/{libraryId}")
    public Library updateOneLibrary(@PathVariable Long libraryId, @RequestBody LibraryUpdateRequest libraryUpdate){
        return libraryService.updateOneLibraryById(libraryId,libraryUpdate);
    }

    @DeleteMapping("/{libraryId}")
    public  void  deleteOneLibrary(@PathVariable Long libraryId){
        libraryService.deleteOneLibraryById(libraryId);
    }

}
