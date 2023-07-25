package com.onejkspark.example.thread.fork;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkTack extends RecursiveTask<Integer> implements ForkEvent<ForkTack> {

    private final List<Integer> list;

    public ForkTack(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        int workLoad = this.list.size();

        String threadName = Thread.currentThread().getName();

        if (this.list.size() > 100) {

            System.out.println("[" + LocalTime.now() + "][" + threadName + "]" + " Splitting workLoad : " + workLoad);

            sleep(1000);

            List<ForkTack> subtasks = new ArrayList<>();

            subtasks.addAll(createSubtasks());

            for (RecursiveTask subtask : subtasks) {
                subtask.fork();
            }

            Integer result = 0;

            for (ForkTack subtask : subtasks) {
                Integer joinValue = subtask.join();
                result += joinValue;
            }

            return result;
        } else {
            System.out.println("[" + LocalTime.now() + "][" + threadName + "]" + " Doing workLoad myself: " + workLoad);

            return Integer.valueOf(String.valueOf(list.stream().count()));
        }

    }

    @Override
    public List<ForkTack> createSubtasks() {

        List<ForkTack> subtasks = new ArrayList<>();

        subtasks.add(new ForkTack(list.subList(0, list.size() / 2)));

        subtasks.add(new ForkTack(list.subList(list.size() / 2, list.size())));

        return subtasks;
    }

    @Override
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
