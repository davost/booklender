package se.lexicon.d.booklender.dao;

import se.lexicon.d.booklender.model.entity.LibraryUser;

import java.util.List;
import java.util.Optional;

public interface LibraryUserDao {

    LibraryUser save(LibraryUser libraryUser);
    Optional<LibraryUser> findById(int userId);
    List<LibraryUser> findAll();
    void remove(LibraryUser libraryUser);
    LibraryUser update(LibraryUser libraryUser);

}
