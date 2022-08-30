package se.lexicon.d.booklender.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.d.booklender.model.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Book save(Book book) {
        entityManager.persist((book));
        return book;
    }

    @Override
    public Optional<Book> findById(int bookId) {
        return Optional.ofNullable(entityManager.find(Book.class, bookId));
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("Select b from Book b").getResultList();
    }

    @Override
    @Transactional
    public void remove(Book book) {
        findById(book.getBookId()).orElseThrow(() -> new IllegalArgumentException("Data not found exception"));
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return entityManager.merge(book);
    }
}
