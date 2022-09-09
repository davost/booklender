package se.lexicon.d.booklender.controller;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.d.booklender.exception.ObjectDuplicateException;
import se.lexicon.d.booklender.exception.ObjectNotFoundException;
import se.lexicon.d.booklender.model.dto.BookDto;
import se.lexicon.d.booklender.service.BookService;
import se.lexicon.d.booklender.service.LibraryUserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) { this.bookService = bookService; }

    @PostMapping("/")
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto) throws ObjectDuplicateException, se.lexicon.d.booklender.exception.ObjectDuplicateException, ObjectNotFoundException {
        BookDto createdBook = bookService.create(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }
    //todo: should I use bookId or bookid ?????
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> findById(@PathVariable("bookId") Integer bookId) throws ObjectNotFoundException {
        BookDto bookDto = bookService.findById(bookId);
        return ResponseEntity.ok(bookDto);
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody BookDto bookDto) throws ObjectDuplicateException {
        bookService.update(bookDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //todo: why "/" ??
    @GetMapping("/")
    public ResponseEntity<List<BookDto>> findAll() {
        List<BookDto> bookDtos = bookService.findAll();
        return ResponseEntity.ok(bookDtos);

    }

    //b. Create a general find method that is able to find by
    // title, available, reserved and all.
    //Use @RequestParam to define the search parameters.
    // (tip: Make 4 optional params
    //with “all” marked as default)

     //public ResponseEntity<List<BookDto>> findAllParams(@RequestBody BookDto bookDto, @RequestParam (String, boolean "available", "reserved", "all"))

    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> findByParams() {
        // todo> implement id late through the request param
        return null;


    }

}
