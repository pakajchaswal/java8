package com.pc.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class ParallelStream1 {

    public static void main(String[] args) {
        Map<String, List<Integer>> numbersPerThread = IntStream.rangeClosed(1, 160)
                .parallel()
                .boxed()
                .collect(groupingBy(i -> Thread.currentThread().getName()));

        numbersPerThread.forEach((k, v) -> System.out.println(String.format("%s >> %s", k, v)));
    }
}
