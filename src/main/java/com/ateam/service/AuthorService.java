package com.ateam.service;


import com.ateam.entity.Author;

public interface AuthorService extends GenericService<Author> {
    Long countAll();
}
