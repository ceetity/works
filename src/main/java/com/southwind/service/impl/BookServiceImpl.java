package com.southwind.service.impl;

import com.southwind.entity.Book;
import com.southwind.entity.User;
import com.southwind.repository.BookMapper;
import com.southwind.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public Book findBooksByName(String bookName) {
        return  bookMapper.findBooksByName(bookName);
    }

    @Override
    public void sellBooks(Book book) {
        bookMapper.sellBooks(book);
    }

    @Override
    public void addBooks(Book book) {
        bookMapper.addBooks(book);
    }

    @Override
    public void updateBooks(Book book) {
        bookMapper.updateBooks(book);
    }

    @Override
    public void deleteBooks(String bookName) {
        bookMapper.deleteBooks(bookName);
    }
}
