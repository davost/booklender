package se.lexicon.d.booklender.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.d.booklender.model.entity.LibraryUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class LibraryUserDaoImpl implements LibraryUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public LibraryUser save(LibraryUser libraryUser) {
        entityManager.persist(libraryUser);
        return libraryUser;
    }

    @Override
    public Optional<LibraryUser> findById(int userId) {
        return Optional.ofNullable(entityManager.find(LibraryUser.class, userId));
    }

    @Override
    public List<LibraryUser> findAll() {
        return entityManager.createQuery("Select l from LibraryUser l").getResultList(); }

    @Override
    @Transactional
    public void remove(LibraryUser libraryUser) {
        findById(libraryUser.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found exception"));
        entityManager.remove(libraryUser);
    }

    @Override
    @Transactional
    public LibraryUser update(LibraryUser libraryUser) {
        return entityManager.merge(libraryUser);
    }
}
