package org.scu_db.demo.service;

import org.scu_db.demo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(Integer Id);

    Integer findCallNumber();

    List<Book> findBookByIdUseSql(Integer Id);

    List<Integer> findAllBookId();

    Integer deleteBookById(Integer id);



    List<String> findSomeOfCallNunber();

    Integer updateBook(Book book, Integer method);
}
