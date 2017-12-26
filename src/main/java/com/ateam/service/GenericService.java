package com.ateam.service;

import java.util.List;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.transaction.CannotCreateTransactionException;

import com.ateam.util.Delay;

@EnableRetry
public interface GenericService<T>  {
    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = Delay.DELAY,
            maxDelay = Delay.MAX_DELAY,
            multiplier = Delay.MULTIPLIER))
    List<T> findAll();

    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = Delay.DELAY,
            maxDelay = Delay.MAX_DELAY,
            multiplier = Delay.MULTIPLIER))
    T findById(Long id);

    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = Delay.DELAY,
            maxDelay = Delay.MAX_DELAY,
            multiplier = Delay.MULTIPLIER))
    T save(T entity);

    @Retryable(
        value = CannotCreateTransactionException.class,
        backoff = @Backoff(delay = Delay.DELAY,
            maxDelay = Delay.MAX_DELAY,
            multiplier = Delay.MULTIPLIER))
    void delete(Long id);

}
