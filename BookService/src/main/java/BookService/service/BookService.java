package BookService.service;

import BookService.entity.Book;
import BookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getAllBooks(){
        return repository.findAll();
    }
    public Book getBookById(int id) {
        return repository.findById(id).get();
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(Book book){
        Book book1=repository.findById(book.getId()).orElse(null);
        book1.setName(book.getName());
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
        return repository.save(book1);
    }


}
