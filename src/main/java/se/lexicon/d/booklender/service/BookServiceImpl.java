package se.lexicon.d.booklender.service;

import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.d.booklender.model.dto.BookDto;
import se.lexicon.d.booklender.model.entity.Book;
import se.lexicon.d.booklender.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    ModelMapper modelMapper;

    // autowired
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto create(BookDto bookDto) throws ObjectNotFoundException {

        if (bookDto == null) throw new IllegalArgumentException("book dto was null");
        if (bookDto.getBookId() != 0) throw new IllegalArgumentException("book dto id must be null");
        /*Book bookEntity = new Book(bookDto.getBookId(),bookDto.getTitle(),bookDto.isAvailable(),bookDto.isReserved(),bookDto.getMaxLoanDays(),bookDto.getFinePerDay(),bookDto.getDescription());
        Book createdEntity = bookRepository.save(bookEntity);
        BookDto result = new BookDto(createdEntity.getBookId(),createdEntity.getTitle(),createdEntity.isAvailable(),createdEntity.isReserved(),createdEntity.getMaxLoanDays(),createdEntity.getFinePerDay(),createdEntity.getDescription());
        return result;*/
        Book bookEntity = modelMapper.map(bookDto,Book.class);
        Book createdEntity = bookRepository.save(bookEntity);
        BookDto result = modelMapper.map(createdEntity, BookDto.class);
        return result;
    }

    @Override
    public BookDto findById(Integer bookId) throws ObjectNotFoundException {
        if (bookId == null) throw new IllegalArgumentException("Id not found");
        Book result = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book ID not found"));
        return modelMapper.map(result, BookDto.class);
    }

    @Override
    public List<BookDto> findAll() {
        return modelMapper.map(bookRepository.findAll() , new TypeToken<List<BookDto>>() {}.getType());
    }

    @Override
    public void update(BookDto bookDto) {
        if (bookDto == null) throw new IllegalArgumentException("Book dto is null");
        if (bookDto.getBookId() == 0) throw new IllegalArgumentException("Book ID must not be null.");
        Book convertedToEntity = modelMapper.map(bookDto, Book.class);
        bookRepository.save(convertedToEntity);
    }

    @Override
    public boolean delete(Integer bookId) throws ObjectNotFoundException {
        findById(bookId);
        bookRepository.deleteById(bookId);
        return true;
    }

    @Override
    public List<BookDto> findByTitle(String title) throws ObjectNotFoundException {
        if (title == null) throw new IllegalArgumentException("Title is null.");
        return modelMapper.map(bookRepository.findByTitle(title) , new TypeToken<List<BookDto>>() {}.getType());

    }

    @Override
    public List<BookDto> findByReserved(boolean reserved) throws ObjectNotFoundException {
        return modelMapper.map(bookRepository.findByReserved(reserved) , new TypeToken<List<BookDto>>() {}.getType());
    }

    @Override
    public List<BookDto> findByAvailable(boolean available) {
        return modelMapper.map(bookRepository.findByReserved(available) , new TypeToken<List<BookDto>>() {}.getType());
    }


}
