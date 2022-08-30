package se.lexicon.d.booklender.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryUserDto {

    private int userID;
    private LocalDate regDate;
    private String name;
    private String email;
}
