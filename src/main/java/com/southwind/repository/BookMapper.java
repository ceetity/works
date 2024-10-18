package com.southwind.repository;

import com.southwind.entity.Book;

import java.util.List;

public interface BookMapper {
    public List<Book> findAllBooks();

    public Book  findBooksByName(String bookName);

    public void sellBooks(Book book);

    public  void updateBooks(Book book);

    public void addBooks(Book book);

    public void deleteBooks(String bookName);


}
