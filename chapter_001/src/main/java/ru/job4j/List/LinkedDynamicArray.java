package ru.job4j.List;


import ru.job4j.SimpleArray;

import java.util.Iterator;

public class LinkedDynamicArray<E> implements Iterable<E> {
    public int modCount = 0;
    private DynamicArray<SimpleArrayList<Node>> container;


    private void grow() {
        modCount++;
        SimpleArrayList<Node> tmp = new DynamicArray<SimpleArrayList<Node>>();
        System.arraycopy(container, 0, tmp, 0, container.getSize());
        container = tmp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < container.getSize();
            }

            @Override
            public E next() {
                return (E) container.get(index++);
            }
        };
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
