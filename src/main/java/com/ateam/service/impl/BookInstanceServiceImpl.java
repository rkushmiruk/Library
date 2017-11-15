package com.ateam.service.impl;

import com.ateam.entity.BookInstance;
import com.ateam.repository.BookInstanceRepository;
import com.ateam.service.BookInstanceService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookInstanceService")
@Transactional
public class BookInstanceServiceImpl implements BookInstanceService {
    @Autowired
    private BookInstanceRepository bookInstanceRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BookInstance> findAll() {
        return Lists.newArrayList(bookInstanceRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public BookInstance findById(Long id) {
        return bookInstanceRepository.findOne(id);
    }

    @Override
    @Transactional
    public BookInstance save(BookInstance entity) {
        return bookInstanceRepository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void delete(BookInstance bookInstance) {
        bookInstanceRepository.delete(bookInstance);
    }
}
