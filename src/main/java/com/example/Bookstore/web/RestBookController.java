package com.example.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@RestController
public class RestBookController {
	@Autowired
	private BookRepository repository;

	//get all
    @GetMapping("/books")
    public Iterable<Book> getBooks() {
    	return repository.findAll();
    }
    //delete one
    @DeleteMapping("/books/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
    	repository.deleteById(id);
    	return repository.findAll();
    }
    //create new
    @PostMapping(value="books")
   Book newBook(@RequestBody Book newBook) {
    	return repository.save(newBook);
    }
    //get one
    @GetMapping(value="/books/{id}")
    Optional<Book> getBook(@PathVariable Long id) {
    	return repository.findById(id);
    }
    //edit existing one
    @PutMapping("/books/{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
    	editedBook.setId(id);
    	return repository.save(editedBook);
    }

}
