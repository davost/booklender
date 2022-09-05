package se.lexicon.d.booklender.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.d.booklender.exception.ObjectNotFoundException;
import se.lexicon.d.booklender.model.dto.LoanDto;
import se.lexicon.d.booklender.model.entity.Loan;
import se.lexicon.d.booklender.repository.BookRepository;
import se.lexicon.d.booklender.repository.LibraryUserRepository;
import se.lexicon.d.booklender.repository.LoanRepository;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    LoanRepository loanRepository;
    LibraryUserRepository libraryUserRepository;
    BookRepository bookRepository;
    ModelMapper modelMapper;

    @Autowired
    public LoanServiceImpl(ModelMapper modelMapper,
                           LoanRepository loanRepository,
                           LibraryUserRepository libraryUserRepository,
                           BookRepository bookRepository){
        this.modelMapper = modelMapper;
        this.loanRepository = loanRepository;
        this.libraryUserRepository = libraryUserRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public LoanDto findById(Integer loanId) throws ObjectNotFoundException {
        if (loanId == null) throw new IllegalArgumentException("Loan ID is null.");
        Loan result = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Loan ID not found."));
        return modelMapper.map(result, LoanDto.class);
    }

    @Override
    public List<LoanDto> findByBookId(Integer bookId) throws ObjectNotFoundException {
        if (bookId == null) throw new IllegalArgumentException("Book ID is null.");
        List<Loan> loanList = loanRepository.findByBookBookId(bookId);
        List<LoanDto> loanDtoList = modelMapper.map(
                loanList,
                new TypeToken<List<LoanDto>>() {
                }.getType()
        );
        return loanDtoList;

    }

    @Override
    public List<LoanDto> findByUserId(Integer userId) throws ObjectNotFoundException {
        if (userId == null) throw new IllegalArgumentException("User ID is null");
        libraryUserRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("User ID is not valid."));

        return modelMapper.map(loanRepository.findByLoanTakerUserId(userId) , new TypeToken<List<LoanDto>>() {}.getType());
    }
    //todo:
    @Override
    public List<LoanDto> findByConcluded(boolean concluded) {
        return modelMapper.map(loanRepository.findByConcluded(concluded) , new TypeToken<List<LoanDto>>() {}.getType());
    }

    @Override
    public List<LoanDto> findAll() {
        return modelMapper.map(loanRepository.findAll() , new TypeToken<List<LoanDto>>() {}.getType());
    }

    @Override
    public LoanDto create(LoanDto loanDto) throws ObjectNotFoundException {
        if (loanDto == null) throw new IllegalArgumentException("LoanDto is null.");
        if (loanDto.getLoanId() != 0) throw new IllegalArgumentException("LoanDto must not be null.");
        Loan loanEntity = modelMapper.map(loanDto, Loan.class);
        Loan createdEntity = loanRepository.save(loanEntity);
        LoanDto result = modelMapper.map(createdEntity, LoanDto.class);
        return result;
    }

    @Override
    public void update(LoanDto loanDto) {
        if (loanDto == null) throw new IllegalArgumentException("LoanDto is null.");
        if (loanDto.getLoanId() == 0) throw new IllegalArgumentException("Loan ID must not be null.");
        Loan convertedEntity = modelMapper.map(loanDto, Loan.class);
        loanRepository.save(convertedEntity);
    }

    @Override
    public void delete(Integer loanId) throws ObjectNotFoundException {
        findById(loanId);

    }
}






