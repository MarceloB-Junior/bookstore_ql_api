package com.api.bookstore_ql.repositories;

import com.api.bookstore_ql.models.AuthorModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel,Long> {
    @Override
    @EntityGraph(attributePaths = "books")
    List<AuthorModel> findAll();

    @Override
    @EntityGraph(attributePaths = "books")
    Optional<AuthorModel> findById(Long aLong);

    boolean existsByName(String name);
}
