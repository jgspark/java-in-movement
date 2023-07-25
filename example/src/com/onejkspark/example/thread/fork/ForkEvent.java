package com.onejkspark.example.thread.fork;

import java.util.List;

public interface ForkEvent<T> {

    List<T> createSubtasks();

    void sleep(int millis);
}
