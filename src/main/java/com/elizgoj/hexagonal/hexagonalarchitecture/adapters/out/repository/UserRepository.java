package com.elizgoj.hexagonal.hexagonalarchitecture.adapters.out.repository;

import com.elizgoj.hexagonal.hexagonalarchitecture.domain.entity.User;


public interface UserRepository {
    void save(User user);
}
