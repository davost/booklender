package se.lexicon.d.booklender.model.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loanTaker")
    private LibraryUser loanTaker;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book")
    private Book book;
    private LocalDate loanDate;
    private boolean concluded;

    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate, boolean concluded) {
        this.loanTaker = loanTaker;
        setBook(book);
        this.loanDate = loanDate;
        this.concluded = concluded;
    }

    public void setBook(Book book) {
        book.setAvailable(false);
        this.book = book;

    }

    public boolean isOverdue() {
        LocalDate dueDate = loanDate.plusDays(book.getMaxLoanDays());
        System.out.println("dueDate = " + dueDate);
        if (LocalDate.now().isAfter(dueDate)) {
            return true;
        } else return false;
    }

    public BigDecimal getFine() {
//
        Period period = Period.between(loanDate.plusDays(book.getMaxLoanDays()), LocalDate.now());
        int daysOverdue = period.getDays();
        int fine = 0;
        if (daysOverdue > 0){
            fine = daysOverdue * book.getFinePerDay().intValue();
        }
        return new BigDecimal(fine);
    }



}
