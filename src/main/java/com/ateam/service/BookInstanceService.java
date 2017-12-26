package com.ateam.service;

import org.springframework.retry.annotation.EnableRetry;

import com.ateam.entity.BookInstance;

@EnableRetry
public interface BookInstanceService extends GenericService<BookInstance> {

}
