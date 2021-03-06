package ru.job4j.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDynamicArray<E> implements Iterable<E> {
    public int modCount = 0;
    private Node<E> first;
    private Node<E> last;
    private int arraySize;

    public E deleteFirst() {
        E tmp = (E) first;
        first = first.next;
        return tmp;
    }

    public E deleteLast() {
        E tmp = (E) last;
        last = last.previous;
        return tmp;
    }

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
        modCount++;
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
        Node<E> tmp = first;
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < arraySize;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                E result = (E) tmp.next;

                count++;
                return result;
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