package ru.job4j.List;

import java.util.Iterator;

public class SimpleStack<T> extends LinkedDynamicArray {
    public T poll() {
        Iterator iterator = iterator();
        T result = null;
        int counter = 0;
        while (iterator.hasNext()) {
            result = (T) iterator.next();
        }
        super.remove(result / index);
        return result;
    }

    public void push(T value) {
        super.add(value);
    }
}