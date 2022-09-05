package se.lexicon.d.booklender.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.d.booklender.exception.ObjectNotFoundException;
import se.lexicon.d.booklender.model.dto.LibraryUserDto;
import se.lexicon.d.booklender.model.entity.LibraryUser;
import se.lexicon.d.booklender.repository.LibraryUserRepository;

import java.util.List;

@Service
public class LibraryUserServiceImpl implements LibraryUserService {

    LibraryUserRepository libraryUserRepository;
    ModelMapper modelMapper;

    @Autowired
    public  LibraryUserServiceImpl(LibraryUserRepository libraryUserRepository, ModelMapper modelMapper) {
        this.libraryUserRepository = libraryUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LibraryUserDto findById(Integer userId) throws ObjectNotFoundException {
        if (userId == null) throw new IllegalArgumentException("ID not found");
        LibraryUser result = libraryUserRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("UserId not found"));
        return modelMapper.map(result, LibraryUserDto.class);
    }

    @Override
    public LibraryUserDto findByEmail(String email) throws ObjectNotFoundException {
        if (email == null) throw new IllegalArgumentException("Email is null");
        LibraryUser result = libraryUserRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Email not found"));
        return modelMapper.map(result, LibraryUserDto.class);
    }

    @Override
    public List<LibraryUserDto> findAll() {
        return modelMapper.map(libraryUserRepository.findAll() , new TypeToken<List<LibraryUserDto>>() {}.getType());
    }

    @Override
    public LibraryUserDto create(LibraryUserDto libraryUserDto) throws ObjectNotFoundException {
        if (libraryUserDto == null) throw new IllegalArgumentException("LibraryDto is null");
        if (libraryUserDto.getUserID() != 0) throw new IllegalArgumentException("LibraryUSerDto is null");
        LibraryUser libraryUserEntity = modelMapper.map(libraryUserDto, LibraryUser.class);
        LibraryUser createdEntity = libraryUserRepository.save(libraryUserEntity);
        LibraryUserDto result = modelMapper.map(createdEntity, LibraryUserDto.class);
        return result;
    }

    @Override
    public void update(LibraryUserDto libraryUserDto) {
        if (libraryUserDto == null) throw new IllegalArgumentException("libraryUserDto is null");
        if (libraryUserDto.getUserID() == 0) throw new IllegalArgumentException("User ID must not be null");
        LibraryUser convertedToEntity = modelMapper.map(libraryUserDto, LibraryUser.class);
        libraryUserRepository.save(convertedToEntity);
        //return libraryUserDto;

    }

    @Override
    public boolean delete(Integer userId) throws ObjectNotFoundException {
        findById(userId);
        libraryUserRepository.deleteById(userId);
        return true;

    }
}
