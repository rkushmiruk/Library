package com.ateam.service.impl;

import com.ateam.entity.Book;
import com.ateam.repository.BookRepository;
import com.ateam.service.BookService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    @Transactional
    public Book save(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void delete(Book entity) {

    }

    @Override
    @Transactional(readOnly = true)
    public Long countAll() {
        return bookRepository.countAllBooks();
    }
}
