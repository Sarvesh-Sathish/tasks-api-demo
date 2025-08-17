package com.example.tasks_api.api;

import com.example.tasks_api.domain.Task;
import com.example.tasks_api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping public List<Task> all() {
        return taskService.all();
    }

    @GetMapping("/id") public Task one(@PathVariable String id) {
        return taskService.get(id);
    }

    @PostMapping public Task create(@Valid @RequestBody Task newTask) {
        return taskService.create(newTask);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable String id, @Valid @RequestBody Task newTask) {
        return taskService.update(id, newTask);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        taskService.delete(id);
    }
}
