package com.elizgoj.hexagonal.hexagonalarchitecture.adapters.in.request;

import com.elizgoj.hexagonal.hexagonalarchitecture.domain.entity.User;
import lombok.Data;


@Data
public class UserRequest {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
