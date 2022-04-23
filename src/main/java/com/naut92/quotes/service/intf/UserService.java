package com.naut92.quotes.service.intf;

import com.naut92.quotes.model.User;

import java.util.Collection;

public interface UserService {
    User createUser(User user);
    Collection<User> getAll();
}
