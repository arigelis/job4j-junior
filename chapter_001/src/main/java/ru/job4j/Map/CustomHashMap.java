package ru.job4j.Map;

import ru.job4j.Tree.Node;

import java.util.*;
import java.util.Map.*;

public class CustomHashMap<K, V> {

    boolean insert(K key, V value) {
        return true;
    }

    V get(K key) {
        return null;
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

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
