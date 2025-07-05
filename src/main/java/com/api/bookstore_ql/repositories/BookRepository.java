package com.api.bookstore_ql.repositories;

import com.api.bookstore_ql.models.AuthorModel;
import com.api.bookstore_ql.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel,Long> {
    boolean existsByTitleAndAuthor(String title, AuthorModel author);
}
