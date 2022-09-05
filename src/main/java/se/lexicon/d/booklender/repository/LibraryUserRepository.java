package se.lexicon.d.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.d.booklender.model.entity.LibraryUser;
import java.util.Optional;
@Repository
public interface LibraryUserRepository extends CrudRepository<LibraryUser, Integer>{

    Optional<LibraryUser> findByEmail(String email);


}
