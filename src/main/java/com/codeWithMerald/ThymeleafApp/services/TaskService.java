package com.codeWithMerald.ThymeleafApp.services;

import com.codeWithMerald.ThymeleafApp.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task save(Task task);

    Task findById(Integer id);

    Task update(Task task);

    void delete(Integer id);
}
