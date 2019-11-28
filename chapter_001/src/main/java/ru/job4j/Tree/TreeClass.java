package ru.job4j.Tree;

import java.util.*;
import java.util.function.Consumer;

public class TreeClass<E extends Comparable<E>> implements SimpleTree<E> {
    //    private final List<Node> children = new ArrayList<>();
    private Node root = null;

    public TreeClass(int i) {
        root = new Node<>(i);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node> tmp = findBy(parent);
        Node<E> searchingNode = new Node<>(parent);
        if (tmp.isPresent()) {
            if (!(tmp.get().leaves().contains(searchingNode))) {
                tmp.get().add(new Node(child));
                result = true;
            }
        }
        return result;
    }


    @Override
    public Optional<Node> findBy(Comparable value) {
        Optional<Node> rsl = Optional.empty();
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
    public Iterator iterator() {
        Queue<Node> data = new LinkedList<>();
        if (root != null) {
            data.offer(this.root);
        }
        return new Iterator() {
            @Override
            public boolean hasNext() {
                if (data.isEmpty())
                    return false;
                else {
                    return true;
                }
            }

            @Override
            public Object next() {
                Node el = data.poll();
                for (Object child : el.leaves()) {
                    data.offer(((Node) child));
                }
                return el;
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
