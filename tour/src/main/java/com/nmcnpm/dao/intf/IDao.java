package com.nmcnpm.dao.intf;

import com.nmcnpm.model.Tour;

import java.util.List;

public interface IDao<T> {
    public List<T> getAll();
    Tour getById(int id);
}
