package com.gonzo.example.thread.fork;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

public class ForkAction extends RecursiveAction {

    private List<Integer> list;

    public ForkAction(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected void compute() {

        int workLoad = this.list.size();

        String threadName = Thread.currentThread().getName();

        if (this.list.size() > 100) {

            System.out.println("[" + LocalTime.now() + "][" + threadName + "]" + " Splitting workLoad : " + workLoad);

            sleep(1000);

            List<ForkAction> subtasks = new ArrayList<ForkAction>();

            subtasks.addAll(createSubtasks());

            for (RecursiveAction subtask : subtasks) {
                subtask.fork();
            }

        } else {
            System.out.println("[" + LocalTime.now() + "][" + threadName + "]" + " Doing workLoad myself: " + workLoad);
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    /**
     * 재귀
     *
     * @return
     */
    private List<ForkAction> createSubtasks() {

        List<ForkAction> subtasks = new ArrayList<ForkAction>();

        subtasks.add(new ForkAction(list.subList(0, list.size() / 2)));

        subtasks.add(new ForkAction(list.subList(list.size() / 2, list.size())));

        return subtasks;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
