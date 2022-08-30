package se.lexicon.d.booklender.model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.d.booklender.repository.LibraryUserRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LibraryUserTest {
    @Autowired
    private LibraryUserRepository testObject;

    @BeforeEach
    public void setup() { testObject.save(new LibraryUser(LocalDate.parse("2022-08-20"), "Sven Svensson", "bb@bb.se"));}

    /*@Test
    public void find_by_email_test() {
        LibraryUser expectedContent = new LibraryUser(1, LocalDate.parse("2022-08-20"), "Sven Svensson", "bb@bb.se");

        Optional<LibraryUser> result = testObject.findByEmail("bb@bb.se");
        assertTrue(result.isPresent());
        assertEquals(expectedContent, result.get());
    } //used wrong test clas for this!*/

    @Test
    public void testObject_successfully_created() {
        /*assertEquals(1, testObject.getUserId());
        assertEquals("Sven Svensson", testObject.getName());
        assertEquals("2022-08-20", testObject.LocalDate.parse());
        assertEquals("bb@bb.se", testObject.findByEmail());*/

        assertEquals(1, testObject.findById());
        //assertEquals("Sven Svensson", testObject.);
        assertEquals("bb@bb.se", testObject.findByEmail());
    }
}
