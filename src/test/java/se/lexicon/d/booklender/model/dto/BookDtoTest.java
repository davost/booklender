package se.lexicon.d.booklender.model.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BookDtoTest {

    BookDto testObject;

    @BeforeEach
    public void setup() {
        testObject = new BookDto(1, "Happy Programming", true, false, 5, BigDecimal.valueOf(0.2), "Programming");

    }

    @Test
    public void test_object_ceated_true() {
        Assertions.assertEquals("Happy Programming", testObject.getTitle());
    }
}
