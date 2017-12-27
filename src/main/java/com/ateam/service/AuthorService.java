package com.ateam.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.transaction.CannotCreateTransactionException;

import com.ateam.entity.Author;
import com.ateam.util.Delay;

@EnableRetry
public interface AuthorService extends GenericService<Author> {

    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = Delay.DELAY,
            maxDelay = Delay.MAX_DELAY,
            multiplier = Delay.MULTIPLIER))
    Long countAll();
}
