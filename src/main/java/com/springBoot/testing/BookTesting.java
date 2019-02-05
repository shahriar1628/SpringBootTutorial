package com.springBoot.testing;

import com.springBoot.book.Book;
import com.springBoot.book.BookRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)

@DataJpaTest
public class BookTesting {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @MockBean
    private BookRepository mockBookrepo;

    @Before
    public void setup() {

        Book book = new Book();
        book.setReader("shahriar");
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        Mockito.when(bookRepository.findByReader("shahriar"))
                .thenReturn(books);
    }



    @Test
    public void findByReaderTest(){
        Book book = new Book();
        book.setReader("shahriar");
        testEntityManager.persist(book);
        testEntityManager.flush();

        List<Book> books =  bookRepository.findByReader("shahriar");
        Book foundBook = books.get(0);

        assertThat(foundBook.getReader())
                .isEqualTo(book.getReader());

    }

}
