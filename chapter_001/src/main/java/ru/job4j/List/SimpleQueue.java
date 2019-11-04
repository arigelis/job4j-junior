package ru.job4j.List;

import org.testng.annotations.Test;

public class SimpleQueue<T> {
    private SimpleStack<String> list1 = new SimpleStack<String>();
    private SimpleStack<String> list2 = new SimpleStack<String>();

    public SimpleQueue() {
        list1.push(new String("1"));
        list1.push(new String("2"));
        list1.push(new String("3"));

        while (!list1.poll().isEmpty()) {
            list2.push(list1.poll());
        }
    }
}