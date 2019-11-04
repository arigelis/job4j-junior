package ru.job4j.List;

import java.util.Queue;

public class SimpleQueue<T> {
    private SimpleStack stackIn = new SimpleStack<T>();
    private SimpleStack stackOut = new SimpleStack<T>();

    public T poll() {
        return (T) stackOut.poll();
    }

    public void push(T value) {
        stackIn.push(value);
        stackOut.push(stackIn.poll());
    }
}