package org.krytev.bookstore.services;

import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.GenreEntity;
import org.krytev.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService{
   private final BookRepository bookRepository;

   @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(BookEntity book){
        bookRepository.save(book);
    }

    public void update(long id, BookEntity bookUpdate){
       BookEntity book = bookRepository.findById(id).orElseThrow();
       book = bookUpdate;
       book.setId(id);
       bookRepository.save(book);
    }

    public void delete(BookEntity book){
       bookRepository.delete(book);
    }

    public void deleteById(long id){
       bookRepository.deleteById(id);
    }

    public BookEntity findById(long id){
       return bookRepository.findById(id).orElseThrow();
    }

    public List<BookEntity> findAll(){
      return bookRepository.findAll();
    }

    public List<BookEntity> findMostLiked(){
        System.out.println(bookRepository.findMostLiked(PageRequest.ofSize(15)));
       return bookRepository.findMostLiked(PageRequest.ofSize(15));
    }

    public List<BookEntity> findNewBooks(){
        return bookRepository.findNewBooks(PageRequest.ofSize(15));
    }

    public List<BookEntity> findByGenre(GenreEntity genre){
        return bookRepository.findByGenre(genre, PageRequest.ofSize(15));
    }
}
