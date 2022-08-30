package se.lexicon.d.booklender.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data // seter,t getter required constructor + equal and hashcode
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private int bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;
}
