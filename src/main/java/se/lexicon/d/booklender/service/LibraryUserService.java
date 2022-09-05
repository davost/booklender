package se.lexicon.d.booklender.service;

import se.lexicon.d.booklender.exception.ObjectNotFoundException;
import se.lexicon.d.booklender.model.dto.LibraryUserDto;

import java.util.List;

public interface LibraryUserService {

    LibraryUserDto findById(Integer userId) throws ObjectNotFoundException;
    LibraryUserDto findByEmail(String email) throws ObjectNotFoundException;
    List<LibraryUserDto> findAll();
    LibraryUserDto create(LibraryUserDto libraryUserDto) throws ObjectNotFoundException;
    void update(LibraryUserDto libraryUserDto) throws ObjectNotFoundException;
    boolean delete(Integer userId) throws ObjectNotFoundException;


}
