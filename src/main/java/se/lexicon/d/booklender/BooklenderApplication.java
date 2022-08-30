package se.lexicon.d.booklender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.d.booklender.model.entity.LibraryUser;

import javax.persistence.OneToMany;

@SpringBootApplication
public class BooklenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooklenderApplication.class, args);
	}

	public LibraryUser libraryUser = new LibraryUser();

	public void setLibraryUser(LibraryUser libraryUser) {
		this.libraryUser = libraryUser;

	}



}
