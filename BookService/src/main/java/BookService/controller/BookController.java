package BookService.controller;

import BookService.entity.Book;
import BookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id){
        return service.getBookById(id);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return service.saveBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return service.updateBook(book);
    }



}
