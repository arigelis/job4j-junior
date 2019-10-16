package ru.job4j.List;

public class SimpleQueue<T> {
    LinkedDynamicArray list = new LinkedDynamicArray();

    public T poll() {
        return (T) list.deleteFirst();
    }

    public void push(T value) {
        list.add(value);
    }
}