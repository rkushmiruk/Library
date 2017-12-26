package com.ateam.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.transaction.CannotCreateTransactionException;

import com.ateam.entity.Book;

@EnableRetry
public interface BookService extends GenericService<Book> {
    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = 5000,
            maxDelay = 100000,
            multiplier = 2))
    Long countAll();
}
