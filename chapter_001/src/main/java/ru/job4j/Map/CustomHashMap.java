package ru.job4j.Map;

import java.util.*;

public class CustomHashMap<K, V> {
    private Node<K, V>[] nodes = new Node[16];
    int length = 0;



    boolean insert(K key, V value) {
        if (nodes.length - 1 >= length) {
            Node<K, V> a = new Node<>(key, value);
//            nodes[length] = new Node<>((K) (a.hashCode()), value);
        } else {
            grow();
            nodes[length] = new Node<>(key, value);
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
