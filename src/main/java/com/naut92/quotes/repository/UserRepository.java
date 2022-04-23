package com.naut92.quotes.repository;

import com.naut92.quotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
