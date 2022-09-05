package se.lexicon.d.booklender.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.d.booklender.model.entity.LibraryUser;

import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
public class LibraryUserRepositoryTest {

    @Autowired // dependency injection
    LibraryUserRepository testObject;


    @Test
    public void test_save_user() {
        LibraryUser libraryUser = new LibraryUser(LocalDate.parse("2022-08-20"), "Sven Svensson", "bb@bb.se");
        testObject.save(libraryUser);

        Optional<LibraryUser> optionalLibraryUser = testObject.findByEmail("bb@bb.se");

        LibraryUser expectedData = new LibraryUser(1, LocalDate.parse("2022-08-20"), "Sven Svensson", "bb@bb.se");
        LibraryUser actualData = optionalLibraryUser.get();

        Assertions.assertEquals(expectedData, actualData);

    }


}
