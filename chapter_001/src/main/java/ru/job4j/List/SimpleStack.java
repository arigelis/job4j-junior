package ru.job4j.List;

public class SimpleStack<T> {
    LinkedDynamicArray list = new LinkedDynamicArray();

    public T poll() {
        return (T) list.deleteLast();
    }

    public T pollFirst() {
        return (T) list.deleteFirst();
    }

    public void push(T value) {
        list.add(value);
    }
}