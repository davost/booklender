package se.lexicon.d.booklender.service;


import se.lexicon.d.booklender.exception.ObjectNotFoundException;
import se.lexicon.d.booklender.model.dto.BookDto;
import java.util.List;

public interface BookService {

    List<BookDto> findByReserved(boolean reserved);
    List<BookDto> findByAvailable(boolean available);
    List<BookDto> findByTitle(String title) throws ObjectNotFoundException;
    BookDto findById(Integer bookId) throws ObjectNotFoundException;
    List<BookDto> findAll();
    BookDto create(BookDto bookDto) throws ObjectNotFoundException;
    void update(BookDto bookDto);
    boolean delete(Integer bookId) throws ObjectNotFoundException;
}
