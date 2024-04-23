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
@RequestMapping("/api/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<Book>> getAllBooks() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        return new ResponseEntity<>(bookRepository.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping(params = {"title"})
    public ResponseEntity<Collection<Book>> findBookByTitle(@RequestParam(value = "title") String title) {
        return new ResponseEntity<>(bookRepository.findByTitle(title), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {

        Optional<Book> optionalBook = bookRepository.findById(id);
        Book currentBook = optionalBook.get();
        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());

        return new ResponseEntity<>(bookRepository.save(currentBook), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
}