package LibraryService.controller;

import LibraryService.entity.Book;
import LibraryService.entity.Library;
import LibraryService.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService service;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Library> getAllLibrary(){
        return service.getAllLibrary();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable("id") int id){
        Book book=restTemplate.getForObject("http://localhost:8081/book/"+id, Book.class);
        Library library = service.getLibraryById(id);
        library.setBook(book);
        return library;
    }

    @PostMapping
    public Library saveLibrary(@RequestBody Library library){
        return service.saveLibrary(library);
    }

    @PutMapping
    public Library updateLibrary(@RequestBody Library library){
        return service.updateLibrary(library);
    }



}
