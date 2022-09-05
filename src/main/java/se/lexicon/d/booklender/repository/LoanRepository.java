package se.lexicon.d.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.d.booklender.model.entity.Book;
import se.lexicon.d.booklender.model.entity.LibraryUser;
import se.lexicon.d.booklender.model.entity.Loan;

import java.util.List;
import java.util.Optional;
@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

    List<Loan> findByLoanTakerUserId(int userId);
    List<Loan> findByBookBookId(int bookId);
    List<Loan> findByConcluded(boolean concluded);

}
