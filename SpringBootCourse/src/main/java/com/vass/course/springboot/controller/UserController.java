package com.vass.course.springboot.controller;

import com.vass.course.springboot.data.User;
import com.vass.course.springboot.dto.UserDTO;
import com.vass.course.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> all() {
        return new ResponseEntity<>(userService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDto) {
        return new ResponseEntity<>(userService.create(new User(userDto)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO userDto, @PathVariable String id) {
        return new ResponseEntity<>(userService.update(new User(userDto), id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        userService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}