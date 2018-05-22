package com.kilopo.kosshop.DAO;

import java.util.List;

public interface BaseDAO<T> {
    T getById(Long id);
    boolean addOrUpdate(T value);
    boolean delete(Long id);
    List<T> getAll();
}