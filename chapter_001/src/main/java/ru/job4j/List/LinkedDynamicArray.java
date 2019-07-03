package ru.job4j.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedDynamicArray<E> implements Iterable<E> {
    private Node[] container = new Node[10];
    private int index = 0;
    public int modCount = 0;
    private Node<E> first;

    public int getSize() {
        return container.length;
    }

    public void add(E value) {
        if (index == 0) {
            first = new Node<>(value);
            first.previous = null;
            index++;
        } else {
            if (index >= container.length) {
                grow();//увеличиваем размер контейнера
            }
            Node<E> tmp = new Node<>(value);
            container[index - 1].next = tmp;//Добавляем "следующий" для предыдущего элемента в стэке
            tmp.previous = container[index - 1];//Добавляем "предыдущий" элемент для текущего в стэке
            container[index++] = tmp;
        }
    }

    public E get(int index) {
        return (E) container[index];
    }

    private void grow() {
        modCount++;
        Node[] tmp = new Node[container.length * 2 + 1];
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

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

        Node(E data) {
            this.data = data;
        }
    }
}
