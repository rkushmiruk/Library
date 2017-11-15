package com.ateam.repository;

import com.ateam.entity.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Query("select count(a) from Author a")
    Long countAllAuthors();
}
