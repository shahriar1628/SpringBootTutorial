package com.springBoot.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.annotation.Generated;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String bookName;
    private String authorName;
    private String reader;

    public Long getID(){
        return  this.id ;
    }
    public String getBookName(){
        return  this.bookName ;
    }
    public String getAuthorName(){
        return  this.authorName ;
    }
    public String getReader(){
        return  this.reader ;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setBookName(String bookName){
        this.bookName = bookName ;
    }
    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }
    public void setReader(String reader){
        this.reader = reader ;
    }


}
