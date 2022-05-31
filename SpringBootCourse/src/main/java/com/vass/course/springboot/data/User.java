package com.vass.course.springboot.data;

import com.vass.course.springboot.dto.UserDTO;

import java.util.Date;
import java.util.UUID;

public class User {

    private String id;
    private String name;
    private String email;
    private String lastName;
    private Date createdAt;

    public User(UserDTO userDTO) {
        this.id = UUID.randomUUID().toString();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.lastName = userDTO.getName();
        this.createdAt = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
