package se.lexicon.d.booklender.model.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class LibraryUser {

    private int userId;
    private LocalDate regDate;
    private String name;
    private String email;

    public LibraryUser(LocalDate regDate, String name, String email) {
        this.regDate = regDate;
        this.name = name;
        this.email = email;
    }


}
