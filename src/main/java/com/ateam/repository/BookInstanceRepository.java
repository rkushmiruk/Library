package com.ateam.repository;

import com.ateam.entity.BookInstance;
import org.springframework.data.repository.CrudRepository;

public interface BookInstanceRepository extends CrudRepository<BookInstance, Long> {
}
