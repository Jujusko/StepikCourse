package com.example.stepikcourse.controller;

import com.example.stepikcourse.model.Task;
import com.example.stepikcourse.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//Будут использованы аннотации: @GetMapping, @PutMapping, @PathVariable, @RequestBody

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @PostMapping("tasks")
    public Task create(@RequestBody Task task)
    {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks/{id}")
    public Task get(@PathVariable(value = "id") long id)
    {
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/tasks/{id}")
    public Task put(@PathVariable(value = "id") long id, @RequestBody Task task)
    {
        return taskRepository.findById(id)
                .map(update -> {
                    update.setDate(task.getDate());
                    update.setDescription(task.getDescription());
                    update.setDone(task.isDone());
                    return taskRepository.save(update); //repository.save(address);
                })
                .orElseGet(() -> {
                    return taskRepository.save(task);
                });
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAll()
    {
        return taskRepository.findAll();
    }
    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable(value = "id") long id)
    {
        taskRepository.deleteById(id);
    }

    @PatchMapping("tasks/{id}")
    public void markAsDone(@PathVariable(value = "id") long id, @RequestBody Task task)
    {
        if (!task.isDone())
        {
            taskRepository.markAsDone(id);
        }
    }

    @PatchMapping("tasks/{id}:mark-as-done")
    public void markAsDone(@PathVariable(value = "id") long id)
    {
        taskRepository.markAsDone(id);
    }
}
