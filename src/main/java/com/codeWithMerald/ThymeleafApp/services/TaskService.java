package com.codeWithMerald.ThymeleafApp.services;

import com.codeWithMerald.ThymeleafApp.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task save(Task task);
}
