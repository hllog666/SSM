package com.hllog.service;

import com.hllog.pojo.Books;

import java.util.List;

public interface BooksService {
    int addBook(Books books);

    int deleteBookById(int id);

    int updateBook(Books books);

    Books queryBookById(int id);

    List<Books> queryAllBook();

    Books queryBookByName(String bookName);
}
