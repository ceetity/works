package com.southwind.service;

import com.southwind.entity.Book;
import com.southwind.entity.User;

import java.util.List;

public interface BookService {
    public List<Book> findAllBooks();

    public Book  findBooksByName(String bookName);

    public void sellBooks(Book book);

    public void addBooks(Book book);

    public void updateBooks(Book book);

    public void deleteBooks(String bookName);

}
