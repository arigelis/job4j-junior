package ru.job4j.Map;

import java.util.*;

public class CustomHashMap<K, V> {
    private Node<K, V>[] nodes = new Node[16];

    boolean insert(K key, V value) {
        Node<K, V> a = new Node<>(key, value);
        int index = key.hashCode() % (nodes.length - 1);
        if (nodes.length - 1 >= index) {
            if (nodes[index] == null) {
                nodes[index] = a;
            } else if (nodes[index].equals(a)) {
                nodes[index] = a;
            }
            nodes[index] = new Node<>(key, value);
        } else {
            grow();
            nodes[index] = new Node<>(key, value);
        }
        return true;
    }

    void grow() {
        Node<K, V>[] tmpNodes = new Node[nodes.length * 3 / 2 + 1];
        tmpNodes = nodes.clone();
    }

    V get(K key) {
        Iterator it = iterator();
        V result = null;
        while (it.hasNext()) {
            Node tmpNode = ((Node) it.next());
            if (tmpNode.key.equals(key)) {
                result = (V) tmpNode.value;
                break;
            }
        }
        return result;
    }

    boolean delete(K key) {
        Iterator it = iterator();
        boolean result = false;
        while (it.hasNext()) {
            Node tmpNode = ((Node) it.next());
            if (tmpNode.key.equals(key)) {
                tmpNode.next = ((Node) it.next()).next;
                result = true;
                break;
            }
        }
        return result;
    }

    public Iterator iterator() {
        return new Iterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return nodes[index].next != null;
            }

            @Override
            public Object next() {
                return nodes[index++];
            }
        };
    }

    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> next = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
