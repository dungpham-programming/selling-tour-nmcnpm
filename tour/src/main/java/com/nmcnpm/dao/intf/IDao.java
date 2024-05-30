package com.nmcnpm.dao.intf;

import com.nmcnpm.model.Tour;

import java.util.List;

public interface IDao<T> {
    List<T> getAll();
    T getById(int id);
}
