package com.springBoot.controller;

import com.springBoot.entity.Book;
import com.springBoot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/{reader}",method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Book> readerlist(@PathVariable("reader") String reader){
        return bookRepository.findByReader(reader);
    }
    @RequestMapping(value = "/{reader}",method = RequestMethod.POST, headers = "Accept=application/json")
    public void addToReaderList(@PathVariable("reader") String reader,Book book){
        book.setReader(reader);
        bookRepository.save(book);
    }
    @RequestMapping(value = "/book",method = RequestMethod.POST, headers = "Accept=application/json")
    public void addBook(@RequestBody Book book){
        bookRepository.save(book);
    }
}
