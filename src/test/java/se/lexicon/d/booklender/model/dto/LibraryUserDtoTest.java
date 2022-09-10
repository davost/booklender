package se.lexicon.d.booklender.model.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LibraryUserDtoTest {

    LibraryUserDto testObject;

    @BeforeEach
    public void setup() {

        testObject = new LibraryUserDto(1, LocalDate.parse("2022-08-31"), "Svenne Svensson", "vv@nn.se");
    }

    @Test
    public void test_object_created_true() {
        Assertions.assertEquals(1, testObject.getUserID());
        Assertions.assertEquals(LocalDate.parse("2022-08-31"), testObject.getRegDate());
        Assertions.assertEquals("Svenne Svensson", testObject.getName());
        Assertions.assertEquals("vv@nn.se", testObject.getEmail());
    }
}
