package se.lexicon.d.booklender.service;

import se.lexicon.d.booklender.exception.ObjectNotFoundException;
import se.lexicon.d.booklender.model.dto.LoanDto;
import java.util.List;

public interface LoanService {

    LoanDto findById(Integer loanId) throws ObjectNotFoundException;
    List<LoanDto> findByBookId(Integer bookId) throws ObjectNotFoundException;
    List<LoanDto> findByUserId(Integer userId) throws ObjectNotFoundException;
    List<LoanDto> findByConcluded(boolean concluded);
    List<LoanDto> findAll();
    LoanDto create(LoanDto loanDto) throws ObjectNotFoundException;
    void update(LoanDto loanDto);
    void delete(Integer loanId) throws ObjectNotFoundException;


}
