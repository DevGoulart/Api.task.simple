package com.kaua.api.infrastructure;

import com.kaua.api.domain.Task;
import com.kaua.api.domain.TaskId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, TaskId> {
}
