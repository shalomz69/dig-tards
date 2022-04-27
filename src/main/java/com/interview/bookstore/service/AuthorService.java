package com.interview.bookstore.service;

import com.interview.bookstore.domain.Author;
import com.interview.bookstore.repository.AuthorRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Author}.
 */
@Service
@Transactional
public class AuthorService {

    private final Logger log = LoggerFactory.getLogger(AuthorService.class);

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Save a author.
     *
     * @param author the entity to save.
     * @return the persisted entity.
     */
    public Author save(Author author) {
        log.debug("Request to save Author : {}", author);
        return authorRepository.save(author);
    }

    /**
     * Update a author.
     *
     * @param author the entity to save.
     * @return the persisted entity.
     */
    public Author update(Author author) {
        log.debug("Request to save Author : {}", author);
        return authorRepository.save(author);
    }

    /**
     * Partially update a author.
     *
     * @param author the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Author> partialUpdate(Author author) {
        log.debug("Request to partially update Author : {}", author);

        return authorRepository
            .findById(author.getId())
            .map(existingAuthor -> {
                if (author.getName() != null) {
                    existingAuthor.setName(author.getName());
                }

                return existingAuthor;
            })
            .map(authorRepository::save);
    }

    /**
     * Get all the authors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Author> findAll(Pageable pageable) {
        log.debug("Request to get all Authors");
        return authorRepository.findAll(pageable);
    }

    /**
     * Get one author by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Author> findOne(Long id) {
        log.debug("Request to get Author : {}", id);
        return authorRepository.findById(id);
    }

    /**
     * Delete the author by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Author : {}", id);
        authorRepository.deleteById(id);
    }
}
