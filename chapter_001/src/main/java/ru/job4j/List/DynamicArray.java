package ru.job4j.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicArray<E> implements Iterable<E> {
    private Object[] container = new Object[10];
    private int index = 0;
    public int modCount = 0;

    public void add(E value) {
        if (index < container.length) {
            container[index++] = value;
        } else {
            grow();
            container[index++] = value;
        }
    }

    public E get(int index) {
        return (E) container[index];
    }

    private void grow() {
        modCount++;
        Object[] tmp = new Object[container.length * 2 + 1];
        System.arraycopy(container, 0, tmp, 0, container.length);
        container = tmp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int pos = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return pos < container.length;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[pos++];
            }
        };
    }
}
