package com.kaua.api.application;

import com.kaua.api.domain.Task;
import com.kaua.api.domain.TaskId;
import com.kaua.api.infrastructure.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public Task create(String title, String description) {
        Task task = new Task(title, description);

        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(UUID id) {
        TaskId taskId = new TaskId(id);

        return taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new RuntimeException("Tarefa não encontrada"));
    }

    public Task update(UUID id, String title, String description) {
        Task task = findById(id);

        task.update(title, description);

        return taskRepository.save(task);
    }

    public Task start(UUID id) {
        Task task = findById(id);

        task.start();

        return taskRepository.save(task);
    }

    public Task complete(UUID id) {
        Task task = findById(id);

        task.complete();

        return taskRepository.save(task);
    }

    public void delete(UUID id) {
        Task task = findById(id);

        taskRepository.delete(task);
    }
}
