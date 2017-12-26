package com.ateam.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.transaction.CannotCreateTransactionException;

import com.ateam.entity.Book;
import com.ateam.util.Delay;

@EnableRetry
public interface BookService extends GenericService<Book> {
    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = Delay.DELAY,
            maxDelay = Delay.MAX_DELAY,
            multiplier = Delay.MULTIPLIER))
    Long countAll();
}
