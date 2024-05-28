package com.nmcnpm.service.intf;

import java.util.List;

public interface IService<T> {
    public List<T> getAll();
}
