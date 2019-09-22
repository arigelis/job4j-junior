package ru.job4j.Set;

import ru.job4j.List.DynamicArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> {
    DynamicArray<E> list = new DynamicArray<>();

    boolean contains(E tmp) {
        boolean result = false;
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            if (Objects.equals(tmp, iter.next())) {
                result = true;
                break;
            }
        }
        return result;
    }

    void add(E e) {
        if (!contains(e)) {
            list.add(e);
        }
    }
}
