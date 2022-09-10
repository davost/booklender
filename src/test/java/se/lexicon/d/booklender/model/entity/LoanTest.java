package se.lexicon.d.booklender.model.entity;

import org.junit.jupiter.api.BeforeEach;
import se.lexicon.d.booklender.model.dto.BookDto;
import se.lexicon.d.booklender.model.dto.LibraryUserDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanTest {

    Loan testObject;
    Book testObject3;
    LibraryUser testObject2;

    @BeforeEach
    public void setup() {
        testObject3 = new Book(1, "Happy Programming", true, false, 5, BigDecimal.valueOf(0.2), "Programming");
        testObject2 = new LibraryUser(1, LocalDate.parse("2022-08-25"), "Sven Svensson", "bb@cc.se");
        testObject = new Loan(1L, testObject2, testObject3, LocalDate.parse("2022-08-29"), false);
    }

    public void test_object_created() {

    }
}
