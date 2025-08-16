package com.example.tasks_api.service;

import com.example.tasks_api.common.NotFoundException;
import com.example.tasks_api.domain.Task;
import com.example.tasks_api.domain.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> all() {
        return repo.findAll();
    }

    public Task get(String id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Task %s not found".formatted(id)));
    }

    public Task create(Task task) {
        task.setId(null);
        task.setDone(false);
        return repo.save(task);
    }

    public Task update(String id, Task task) {
        Task updatedTask = get(id);
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setDone(task.isDone());
        return repo.save(updatedTask);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
