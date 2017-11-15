package com.ateam.service;

import com.ateam.entity.Book;

public interface BookService extends GenericService<Book> {
    Long countAll();
}
