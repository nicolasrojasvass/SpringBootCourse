package com.vass.course.springboot.service;

import com.vass.course.springboot.data.Task;
import com.vass.course.springboot.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ImplTaskService implements TaskService{

    private final HashMap<String, Task> tasksHashMap = new HashMap<>();

    @Override
    public Task create(Task task) {
        tasksHashMap.put(task.getId(), task);
        return tasksHashMap.get(task.getId());
    }

    @Override
    public Task findById(String id) {
        return tasksHashMap.get(id);
    }

    @Override
    public List<Task> all() {
        return new ArrayList<>(tasksHashMap.values());
    }

    @Override
    public void deleteById(String id) {
        tasksHashMap.remove(id);
    }

    @Override
    public Task update(Task task, String id) {
        Task taskUpdate = tasksHashMap.get(task.getId());
        if (taskUpdate != null) {
            taskUpdate.setName(task.getName());
            taskUpdate.setStatus(task.getStatus());
            taskUpdate.setDescription(task.getDescription());
            taskUpdate.setAssignedTo(task.getAssignedTo());
            taskUpdate.setCreated(task.getCreated());
            return taskUpdate;
        } else {
            return null;
        }
    }
}
