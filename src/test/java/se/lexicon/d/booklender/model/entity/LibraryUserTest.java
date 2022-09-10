package se.lexicon.d.booklender.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LibraryUserTest {


    LibraryUser testObject;


    @BeforeEach
    public void setup(){
        testObject = new LibraryUser(LocalDate.parse("2022-08-20"), "Sven Svensson", "bb@bb.se");

    }

    @Test
    public void testObject_successfully_created() {
        Assertions.assertEquals(LocalDate.parse("2022-08-20") ,testObject.getRegDate());
        Assertions.assertEquals("Sven Svensson", testObject.getName());
        Assertions.assertEquals("bb@bb.se", testObject.getEmail());

    }
}
