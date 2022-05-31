package com.vass.course.springboot.data;

import com.vass.course.springboot.dto.TaskDTO;

import java.util.Date;
import java.util.UUID;

public class Task {
    private String id;
    private String name;
    private String description;
    private String status; // [TODO, DOING, REVIEW and DONE]
    private String assignedTo;
    private Date dueDate;
    private Date created;

    public Task(TaskDTO taskDTO) {
        this.id = UUID.randomUUID().toString();
        this.name = taskDTO.getName();
        this.description = taskDTO.getDescription();
        this.status = taskDTO.getStatus();
        this.assignedTo = taskDTO.getAssignedTo();
        this.dueDate = taskDTO.getDueDate();
        this.created = taskDTO.getCreated();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
