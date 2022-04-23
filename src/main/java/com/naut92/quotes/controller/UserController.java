package com.naut92.quotes.controller;

import com.naut92.quotes.model.User;
import com.naut92.quotes.service.intf.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ApiOperation(value = "Create user")
    @PostMapping("/{user}")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(service.createUser(user));
    }
}
