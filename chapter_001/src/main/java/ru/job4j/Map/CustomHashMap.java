package ru.job4j.Map;

import ru.job4j.Tree.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CustomHashMap<K, V> {
    K array[] = new K[10];

    boolean insert(K key, V value) {
        return true;
    }

    V get(K key) {
        return;
    }

    boolean delete(K key) {
        return true;
    }

    public Iterator iterator() {
        return new Iterator() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
