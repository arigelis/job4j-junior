package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable {
    private T[] tmp;
    int index;

    public SimpleArray(int arrayLength) {
        tmp = (T[]) new Object[arrayLength];
    }

    public void add(T model) {
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == null) {
                tmp[i] = model;
                break;
            }
        }
    }

    public boolean set(int index, T model) {
        boolean result = false;
        if (index < tmp.length) {
            tmp[index] = model;
            result = true;
        }
        return result;
    }

    public boolean remove(int index) {//Здесь не знал как именно реализовать удаление, сделал просто =null.
        boolean result = false;       //Могу переделать со смещением всех последующих элементов, если так правильнее.
        if (index < tmp.length) {
            tmp[index] = null;
        }
        return false;
    }

    public T get(int index) {
        T curr = null;
        if (index < tmp.length) {
            curr = tmp[index];
        }
        return curr;
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(tmp).iterator();
    }
}
