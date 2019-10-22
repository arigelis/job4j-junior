package ru.job4j.List;

public class CyclicLinkedList {
    private Node firstElement;

    class Node<T> {
        public Node(T value) {
            this.value = value;
        }

        T value;
        Node<T> next;
    }

    public CyclicLinkedList() {
        Node first = new Node(1);
        firstElement = first;
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        hasCycle(first);

    }

    public boolean hasCycle(Node first) {
        boolean result = false;
        while (first.next != null) {
            if (first.equals(first.next)) {
                result = true;
                break;
            }
            if (first.next.equals(firstElement)) {
                break;
            } else {
                first = first.next;
            }
        }
        return result;
    }
}
