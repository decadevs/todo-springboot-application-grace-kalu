package com.codeWithMerald.ThymeleafApp.services;

import com.codeWithMerald.ThymeleafApp.models.Task;
import com.codeWithMerald.ThymeleafApp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Date;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired private TaskRepository taskRepository;
    @Override
    public List<Task> getAllTasks() {

        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        task.setCreatedAt(new Date());

        return taskRepository.save(task);
    }
}
