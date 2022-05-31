package com.vass.course.springboot.service;

import com.vass.course.springboot.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ImplUserService implements UserService {

    private final HashMap<String, User> usersHashMap = new HashMap<>();

    @Override
    public User create(User user) {
        usersHashMap.put(user.getId(), user);
        return usersHashMap.get(user.getId());
    }

    @Override
    public User findById(String id) {
        return usersHashMap.get(id);
    }

    @Override
    public List<User> all() {
        return new ArrayList<>(usersHashMap.values());
    }

    @Override
    public void deleteById(String id) {
        usersHashMap.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        User userUpdate = usersHashMap.get(user.getId());
        if (userUpdate != null) {
            userUpdate.setEmail(user.getEmail());
            userUpdate.setName(user.getName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setCreatedAt(user.getCreatedAt());
            return userUpdate;
        } else {
            return null;
        }
    }
}
