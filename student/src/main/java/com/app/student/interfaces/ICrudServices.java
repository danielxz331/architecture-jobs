package com.app.student.interfaces;

import java.util.List;

public interface ICrudServices<T> {
    List<T> getAll();

    T getById(int id);

    void save(T object);

    void delete(int id);
}
