package com.vass.course.springboot.controller;

import com.vass.course.springboot.data.Task;
import com.vass.course.springboot.data.User;
import com.vass.course.springboot.dto.TaskDTO;
import com.vass.course.springboot.dto.UserDTO;
import com.vass.course.springboot.service.TaskService;
import com.vass.course.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> all() {
        return new ResponseEntity<>(taskService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.create(new Task(taskDTO)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDTO taskDTO, @PathVariable String id) {
        return new ResponseEntity<>(taskService.update(new Task(taskDTO), id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        taskService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}