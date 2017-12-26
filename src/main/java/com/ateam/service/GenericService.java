package com.ateam.service;

import java.util.List;

public interface GenericService<T>  {
    List<T> findAll();

    T findById(Long id);

    T save(T entity);

    void delete(Long id);
}
