package com.interview.bookstore.repository;

import com.interview.bookstore.domain.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Book entity.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    default Optional<Book> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Book> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Book> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select distinct book from Book book left join fetch book.author",
        countQuery = "select count(distinct book) from Book book"
    )
    Page<Book> findAllWithToOneRelationships(Pageable pageable);

    @Query("select distinct book from Book book left join fetch book.author")
    List<Book> findAllWithToOneRelationships();

    @Query("select book from Book book left join fetch book.author where book.id =:id")
    Optional<Book> findOneWithToOneRelationships(@Param("id") Long id);

    @Query(
        value = "select distinct book from Book book left join fetch book.author" +
        " where (:max_price is null or book.price <= :max_price)" +
        " and (:min_price is null or book.price >= :min_price)",
        countQuery = "select count(distinct book) from Book book"
    )
    Page<Book> findByFiltersWithEagerRelationships(
        @Param("max_price") Float maxPrice,
        @Param("min_price") Float minPrice,
        Pageable pageable);

    @Query(
        "select book from Book book" +
        " where (:max_price is null or book.price <= :max_price)" +
        " and (:min_price is null or book.price >= :min_price)"
    )
    Page<Book> findByFilters(
        @Param("max_price") Float maxPrice,
        @Param("min_price") Float minPrice,
        Pageable pageable);
}
