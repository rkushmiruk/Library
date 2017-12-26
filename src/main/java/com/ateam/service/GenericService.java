package com.ateam.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.transaction.CannotCreateTransactionException;

@EnableRetry
public interface GenericService<T>  {
    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = 5000,
            maxDelay = 100000,
            multiplier = 2))
    List<T> findAll();

    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = 5000,
            maxDelay = 100000,
            multiplier = 2))
    T findById(Long id);

    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = 5000,
            maxDelay = 100000,
            multiplier = 2))
    T save(T entity);

    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = 5000,
            maxDelay = 100000,
            multiplier = 2))
    void delete(Long id);

}
