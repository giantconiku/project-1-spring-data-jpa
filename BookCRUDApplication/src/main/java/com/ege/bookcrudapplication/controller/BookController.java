package com.ege.bookcrudapplication.controller;

import com.ege.bookcrudapplication.entity.Book;
import com.ege.bookcrudapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(repository.save(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<Book>> getAllBooks() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping(params = {"title"})
    public ResponseEntity<Collection<Book>> findBookByTitle(@RequestParam(value = "title") String title) {
        return new ResponseEntity<>(repository.findByTitle(title), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {

        Optional<Book> optionalBook = repository.findById(id);
        Book currentBook = optionalBook.get();
        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());

        return new ResponseEntity<>(repository.save(currentBook), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllBooks() {
        repository.deleteAll();
    }
}
