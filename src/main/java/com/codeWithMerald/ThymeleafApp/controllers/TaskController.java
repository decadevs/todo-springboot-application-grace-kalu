package com.codeWithMerald.ThymeleafApp.controllers;

import com.codeWithMerald.ThymeleafApp.models.Task;
import com.codeWithMerald.ThymeleafApp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String tasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        model.addAttribute("title", "My TodoApp");
        model.addAttribute("isCreate", true);

        return "view/tasks";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Task task, RedirectAttributes redirectAttributes, Model model){
        Task newTask = taskService.save(task);

        if(newTask != null){
            redirectAttributes.addFlashAttribute("successMessage", "New Task has been created successful");
            return "redirect:/";
        }
        else {
            model.addAttribute("errorMessage", "There's been an error creating new task");
            model.addAttribute("task", task);
            return "view/tasks";
        }
    }
    @GetMapping(value = "/getTask/ {id}")
    public String getTask(@PathVariable Integer id, Model model){
        Task task = taskService.findById(id);
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", task);
        model.addAttribute("title", "Edit TodoApp");
        model.addAttribute("isCreate", false);
        return "view/tasks";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Task task, RedirectAttributes redirectAttributes, Model model){
        Task newTask = taskService.update(task);

        if(newTask != null){
            redirectAttributes.addFlashAttribute("successMessage", "Task has been updated successful");
            return "redirect:/";
        }
        else {
            model.addAttribute("errorMessage", "There's been an error updating the task, please try again");
            model.addAttribute("task", task);
            return "view/tasks";
        }
    }

    @PostMapping(value = "/deleteTask/{id}")
    public String deleteTask(@ModelAttribute Integer id, RedirectAttributes redirectAttributes, Model model) {
        taskService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Task has been deleted successful");
        return "redirect:/";
    }
}
