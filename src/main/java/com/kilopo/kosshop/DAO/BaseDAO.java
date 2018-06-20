package com.kilopo.kosshop.DAO;

import java.util.List;

public interface BaseDAO<T> {
    T getById(Long id);
    T addOrUpdate(T value);
    void delete(Long id);
    List<T> getAll();
}