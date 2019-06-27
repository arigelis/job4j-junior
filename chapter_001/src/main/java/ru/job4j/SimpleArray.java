package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable {
    private T[] tmp;
    int indexArr;

    public SimpleArray(int arrayLength) {
        tmp = (T[]) new Object[arrayLength];
    }

    public void add(T model) {
        tmp[indexArr] = model;
        indexArr++;
    }

    public boolean set(int index, T model) {
        boolean result = false;
        if (index < indexArr) {
            tmp[index] = model;
            result = true;
        }
        return result;
    }

    public boolean remove(int index) {
        boolean result = false;
        if (index < indexArr) {
            System.arraycopy(tmp, index, tmp, indexArr, tmp.length - 1);
        }


        return result;
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
