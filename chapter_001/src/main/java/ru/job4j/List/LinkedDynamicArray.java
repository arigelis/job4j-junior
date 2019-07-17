package ru.job4j.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedDynamicArray<E> implements Iterable<E> {
    public int modCount = 0;
    private Node<E> first;
    private Node<E> last;
    private int arraySize;

    public void add(E value) {
        if (first == null) {
            first = new Node<>(value);
            first.previous = null;
            last = first;
        } else {
            Node<E> tmp = new Node<>(value);
            tmp.previous = last;
            last = tmp;
        }
        arraySize++;
    }

    public E get(int index) {
        if (first == null) {
            return null;
        }

        Node<E> result = null;
        Node<E> tmp = first;

        int counter = 0;
        while (result == null) {
            if (tmp.next != null) {
                if (counter == index) {
                    result = tmp;
                } else {
                    counter++;
                    tmp = tmp.next;
                }
            } else {
                break;
            }
        }
        return (E) result;
    }

    @Override
    public Iterator<E> iterator() {
        int count = 0;
        Node<E> tmp = first;
        return new Iterator<E>() {
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return count < arraySize;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) tmp.next;
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

        Node(E data) {
            this.data = data;
        }
    }
}
