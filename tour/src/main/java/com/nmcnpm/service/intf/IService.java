package com.nmcnpm.service.intf;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T getById(int id);
}
