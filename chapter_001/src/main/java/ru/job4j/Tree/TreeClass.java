package ru.job4j.Tree;

import java.util.*;
import java.util.function.Consumer;

public class TreeClass<E extends Comparable<E>> implements SimpleTree<E> {
    //    private final List<Node> children = new ArrayList<>();
    private Node root = null;
    public int modCount = 0;

    public TreeClass(int i) {
        root = new Node<>(i);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> tmp = findBy(parent);
        Node<E> searchingNode = new Node<>(parent);
        if (tmp.isPresent()) {
            if (!(tmp.get().leaves().contains(searchingNode))) {
                tmp.get().add(new Node(child));
                result = true;
            }
        }
        modCount++;
        return result;
    }


    @Override
    public Optional<Node<E>> findBy(Comparable value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Object child : el.leaves()) {
                data.offer(((Node) child));
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        Queue<Node<E>> data = new LinkedList<>(Collections.singletonList(root));
//        if (root != null) {
//            data.offer(this.root);
//        }
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                Node<E> el = data.poll();
//                for (Object child : el.leaves()) {
//                    data.offer(((Node) child));
//                }
                data.addAll(el.leaves());
                return el.getValue();
            }
        };
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
