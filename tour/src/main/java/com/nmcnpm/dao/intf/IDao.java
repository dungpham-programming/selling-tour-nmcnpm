package com.nmcnpm.dao.intf;

import java.util.List;

public interface IDao<T> {
    public List<T> getAll();
}
