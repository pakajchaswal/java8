package com.pc.java8.streams;

import com.pc.java8.common.Task;
import com.pc.java8.common.TaskType;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Examples {

    public List<String> allReadingTasks(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.LEARNING).
                sorted(comparing(Task::getCreatedOn)).
                map(Task::getTitle).
                collect(toList());

    }


    public List<String> allReadingTasksSortedByCreatedOnDesc(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.LEARNING).
                sorted(comparing(Task::getCreatedOn).reversed()).
                map(Task::getTitle).
                collect(toList());

    }

    public List<Task> allDistinctTasks(List<Task> tasks) {
        return tasks.stream().distinct().collect(toList());
    }

    public List<String> topN(List<Task> tasks, int n) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.LEARNING).
                sorted(comparing(Task::getCreatedOn)).
                map(Task::getTitle).
                limit(n).
                collect(toList());
    }

    public long countAllReadingTasks(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.LEARNING).
                count();
    }

    public List<String> allDistinctTags(List<Task> tasks) {
        return tasks.stream().flatMap(task -> task.getTags().stream()).distinct().collect(toList());
    }

    public boolean isAllReadingTasksWithTagBooks(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.LEARNING).
                allMatch(task -> task.getTags().contains("books"));
    }

    public boolean isAnyReadingTasksWithTagJava8(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.LEARNING).
                anyMatch(task -> task.getTags().contains("java8"));
    }

    public String joinAllTaskTitles(List<Task> tasks) {
        return tasks.stream().
                map(Task::getTitle).
                reduce((first, second) -> first + " *** " + second).
                get();
    }

}
