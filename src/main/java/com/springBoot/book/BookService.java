package com.springBoot.book;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
 import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
         bookRepository.findAll().forEach(books ::add);
         return  books;
    }
    public List<Book> getBooksByReader(String reader) {
        return bookRepository.findByReader(reader);
    }
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBook(String id){
        return bookRepository.findById(Long.valueOf(id)).get();
    }
    public void updateBook(String id,Book book){
         bookRepository.save(book);
    }
    public void deleteBook(String id){
        bookRepository.delete(getBook(id));
    }




}


