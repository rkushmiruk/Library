package com.ateam.service.impl;

import com.ateam.entity.Author;
import com.ateam.repository.AuthorRepository;
import com.ateam.service.AuthorService;
import com.ateam.util.GitService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService, InitializingBean {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return Lists.newArrayList(authorRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Author findById(Long id) {
        return authorRepository.findOne(id);
    }

    @Override
    @Transactional
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Long countAll() {
        return authorRepository.countAllAuthors();
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        GitService.logGitTagVersion();
    }
}
