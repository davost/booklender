package se.lexicon.d.booklender.model;

import se.lexicon.d.booklender.model.entity.Book;
import se.lexicon.d.booklender.model.entity.LibraryUser;
import se.lexicon.d.booklender.model.entity.Loan;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        Book testBook = new Book("Test", 14, BigDecimal.valueOf(10), "test description");
        // ctrl + P means display constructor parameters
        LibraryUser testUser = new LibraryUser(LocalDate.parse("2022-08-10"), "david", "dd@gg.se");

        Loan testLoan = new Loan(testUser, testBook, LocalDate.parse("2022-08-01"), false);
        System.out.println(testLoan);
        System.out.println(testLoan.isOverdue());
        System.out.println(testBook);
    }
}
