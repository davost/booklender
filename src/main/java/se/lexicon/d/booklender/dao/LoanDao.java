package se.lexicon.d.booklender.dao;

import se.lexicon.d.booklender.model.entity.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanDao {

    Loan save(Loan loan);
    Optional<Loan> findById(Long loanId);
    List<Loan> findAll();
    void remove(Loan loan);
    Loan update(Loan loan);

}

