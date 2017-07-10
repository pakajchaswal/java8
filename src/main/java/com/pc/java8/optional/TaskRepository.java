package com.pc.java8.optional;



import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.pc.java8.common.Task;
import com.pc.java8.common.TaskType;

public class TaskRepository {

    private final Map<String, Task> db = new HashMap<>();

    public void loadData() {
        db.put("1", new Task("1", "hello java 1", TaskType.CODING));
        db.put("2", new Task("2", "hello java 2", TaskType.CODING));
        db.put("3", new Task("3", "hello java 3", TaskType.CODING));
        db.put("4", new Task("4", "hello java 4", TaskType.CODING));
        db.put("5", new Task("5", "hello java 5", TaskType.CODING));
    }

    public Task find(String id) {
        return Optional.ofNullable(db.get(id))
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

}
