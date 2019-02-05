package com.springBoot.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books/reader/{reader}",method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Book> readerlist(@PathVariable("reader") String reader){
        return bookService.getBooksByReader(reader);
    }

    @RequestMapping(value = "/books/{id}",method = RequestMethod.GET, headers = "Accept=application/json")
    public Book getBookById(@PathVariable("id") String id){
        try {
            return bookService.getBook(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @RequestMapping(value = "/books/{id}",method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateBook(@PathVariable("id") String id,@RequestBody Book book){
            bookService.updateBook(id,book);
    }
    @RequestMapping(value = "/books/{id}",method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteBook(@PathVariable("id") String id){
        bookService.deleteBook(id);
    }
    /*
    @RequestMapping(value = "/{reader}",method = RequestMethod.POST, headers = "Accept=application/json")
    public void addToReaderList(@PathVariable("reader") String reader,Book book){
        book.setReader(reader);
        bookRepository.save(book);
    }*/
    @RequestMapping(value = "/books",method = RequestMethod.POST, headers = "Accept=application/json")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
    @RequestMapping(value = "/books",method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Book> getBooks(){
           return bookService.getAllBooks();
    }
}
