package com.naut92.quotes.service;

import com.naut92.quotes.model.User;
import com.naut92.quotes.repository.UserRepository;
import com.naut92.quotes.service.intf.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }
}
