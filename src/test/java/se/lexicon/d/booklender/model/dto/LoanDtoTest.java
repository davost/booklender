package se.lexicon.d.booklender.model.dto;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDtoTest {

    LoanDto testObject;
    LibraryUserDto testObject2;
    BookDto testObject3;

    @BeforeEach
    public void setup() {

        testObject3 = new BookDto(1, "Happy Programming", true, false, 5, BigDecimal.valueOf(0.2), "Programming");
        testObject2 = new LibraryUserDto(1, LocalDate.parse("2022-08-25"), "Sven Svensson", "bb@cc.se");
        testObject = new LoanDto(1L, testObject2, testObject3, LocalDate.parse("2022-08-30"), false);

    }

    @Test
    public void test_object_created_true() {
        Assertions.assertEquals("Happy Programming", testObject3.getTitle());
        Assertions.assertEquals(true, testObject3.isAvailable());
        Assertions.assertEquals(false, testObject3.isReserved());
        Assertions.assertEquals(5, testObject3.getMaxLoanDays());
        Assertions.assertEquals("Programming", testObject3.getDescription());

        Assertions.assertEquals(1, testObject2.getUserID());
        Assertions.assertEquals(LocalDate.parse("2022-08-25"), testObject2.getRegDate());
        Assertions.assertEquals("Sven Svensson", testObject2.getName());

        Assertions.assertEquals(1L, testObject.getLoanId());
        Assertions.assertEquals(LocalDate.parse("2022-08-30"), testObject.getLoanDate());
        Assertions.assertEquals(false, testObject.isConcluded());
    }
}
