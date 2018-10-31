package com.kilopo.kosshop.DAO;

import java.util.List;
import java.util.Map;

public interface BaseDAO<T> {
    T getById(Long id);
    T addOrUpdate(T value);
    T add(T value);
    boolean delete(Long id);
    List<T> getAll();
    List<T> getByColumnNameAndValue(String name,Object value);
    List<T> findByFields(Map<String, String> allParams);
}