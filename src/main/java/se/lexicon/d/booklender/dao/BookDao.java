package se.lexicon.d.booklender.dao;

import se.lexicon.d.booklender.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    Book save(Book book);
    Optional<Book> findById(int bookId);
    List<Book> findAll();
    void remove(Book book);
    Book update(Book book);
}
