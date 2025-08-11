package com.elizgoj.hexagonal.hexagonalarchitecture.adapters.out.repository.impl;

import com.elizgoj.hexagonal.hexagonalarchitecture.adapters.out.repository.UserRepository;
import com.elizgoj.hexagonal.hexagonalarchitecture.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> database = new ArrayList<>();

    @Override
    public void save(User user) {
        database.add(user);
        System.out.println("Usuário salvo: " + user);
    }

}
