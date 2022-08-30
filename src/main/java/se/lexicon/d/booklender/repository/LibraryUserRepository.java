package se.lexicon.d.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.d.booklender.model.entity.LibraryUser;

import java.util.Optional;

public interface LibraryUserRepository extends CrudRepository<LibraryUser, Integer>{

    Optional<LibraryUser> findByEmail(String email);

    //int findById();
}
