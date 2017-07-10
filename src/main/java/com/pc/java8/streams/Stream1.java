package com.pc.java8.streams;


import com.pc.java8.common.Task;
import com.pc.java8.common.TaskType;

import java.util.List;
import java.util.stream.Collectors;

import static com.pc.java8.common.DataUtils.getTasks;


public class Stream1 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        List<String> readingTasks = tasks.stream()
                .filter(task -> task.getType() == TaskType.LEARNING)
                .sorted((t1, t2) -> t1.getTitle().length() - t2.getTitle().length())
                .map(Task::getTitle)
                .collect(Collectors.toList());

        readingTasks.forEach(System.out::println);
    }
}
