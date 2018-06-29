package com.kilopo.kosshop.DAO;

import java.util.List;

public interface BaseDAO<T> {
    T getById(Long id);
    T addOrUpdate(T value);
    boolean delete(Long id);
    List<T> getAll();
    List<T> getByColumnNameAndValue(String name,Object value);
}