package se.lexicon.d.booklender.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.d.booklender.exception.ObjectDuplicateException;
import se.lexicon.d.booklender.model.dto.LibraryUserDto;
import se.lexicon.d.booklender.model.entity.LibraryUser;
import se.lexicon.d.booklender.service.LibraryUserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libraryUser")
public class LibraryUserController {

    LibraryUserService libraryUserService;

    @Autowired
    public LibraryUserController(LibraryUserService libraryUserService) { this.libraryUserService = libraryUserService;}

    @GetMapping("/{userId}")
    public ResponseEntity<LibraryUserDto> findById(@PathVariable ("userId") Integer userId) throws ObjectNotFoundException, se.lexicon.d.booklender.exception.ObjectNotFoundException {
        LibraryUserDto libraryUserDto = libraryUserService.findById(userId);
        return ResponseEntity.ok(libraryUserDto);
    }

    @GetMapping("/{email}")
    public ResponseEntity<LibraryUserDto> findByEmail(@PathVariable("email") String email) throws ObjectNotFoundException, se.lexicon.d.booklender.exception.ObjectNotFoundException {
        LibraryUserDto libraryUserDto = libraryUserService.findByEmail(email);
        return ResponseEntity.ok(libraryUserDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<LibraryUserDto>> findAll() {
        List<LibraryUserDto> libraryUserDtos = libraryUserService.findAll();
        return ResponseEntity.ok(libraryUserDtos);
    }
    //todo: not working now
    @PostMapping("/")
    public ResponseEntity<LibraryUserDto> create(@RequestBody LibraryUserDto libraryUserDto) throws ObjectDuplicateException, se.lexicon.d.booklender.exception.ObjectNotFoundException {
        LibraryUserDto createdLibraryUser = libraryUserService.create(libraryUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLibraryUser);
    }
    //todo: not working now
    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody LibraryUserDto libraryUserDto) throws se.lexicon.d.booklender.exception.ObjectNotFoundException {
        libraryUserService.update(libraryUserDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
