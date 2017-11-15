package com.ateam.repository;

import com.ateam.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("select count(b) from Book b")
    Long countAllBooks();
}
