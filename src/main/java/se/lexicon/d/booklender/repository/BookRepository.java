package se.lexicon.d.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.d.booklender.model.entity.Book;
import java.util.List;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByTitle(String title);
    List<Book> findByAvailable(boolean available);
    List<Book> findByReserved(boolean reserved);

}
