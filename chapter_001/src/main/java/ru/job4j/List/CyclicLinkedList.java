package ru.job4j.List;

public class CyclicLinkedList {
    private Node tortoise;
    private Node rabbit;

    class Node<T> {
        public Node(T value) {
            this.value = value;
        }

        T value;
        Node<T> next;
    }

    public CyclicLinkedList() {
        Node first = new Node(1);
        tortoise = first;
        rabbit = first;
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        System.out.println("" + hasCycle());

    }

    public boolean hasCycle() {
        boolean result = false;
        while (rabbit != null && rabbit.next != null) {
            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
            if (tortoise == rabbit) {
                result = true;
                break;
            }
        }
        return result;
    }
}
