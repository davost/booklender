package se.lexicon.d.booklender.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BookTest {

    Book testObject;

    @BeforeEach
    public void setup() {
        testObject = new Book(1, "Java Today", true, false, 8, BigDecimal.valueOf(5L,1), "beginners book" );
    }

    @Test
    public void test_object_created_true() {
        Assertions.assertEquals(1, testObject.getBookId());
        Assertions.assertEquals("Java Today", testObject.getTitle());
        Assertions.assertEquals(true, testObject.isAvailable());
        Assertions.assertEquals(false, testObject.isReserved());
        Assertions.assertEquals(8, testObject.getMaxLoanDays());
        Assertions.assertEquals(BigDecimal.valueOf(5L, 1), testObject.getFinePerDay());
    }
}
