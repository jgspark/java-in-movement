package com.gonzo.example.thread.fork;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ForkAction extends RecursiveAction {

    private long workLoad = 0;

    public ForkAction(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {

        String threadName = Thread.currentThread().getName();

        // if work is above threshold, break tasks up into smaller tasks
        if (this.workLoad > 16) {

            System.out.println("[" + LocalTime.now() + "][" + threadName + "]" + " Splitting workLoad : " + this.workLoad);

            sleep(1000);

            List<ForkAction> subtasks = new ArrayList<ForkAction>();

            subtasks.addAll(createSubtasks());

            for (RecursiveAction subtask : subtasks) {
                subtask.fork();
            }

        } else {
            System.out.println("[" + LocalTime.now() + "][" + threadName + "]" + " Doing workLoad myself: " + this.workLoad);
        }
    }

    private List<ForkAction> createSubtasks() {
        List<ForkAction> subtasks = new ArrayList<ForkAction>();

        ForkAction subtask1 = new ForkAction(this.workLoad / 2);
        ForkAction subtask2 = new ForkAction(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

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
