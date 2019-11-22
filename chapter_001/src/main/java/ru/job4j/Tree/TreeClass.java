package ru.job4j.Tree;

import java.util.*;
import java.util.function.Consumer;

public class TreeClass implements SimpleTree {
    //    private final List<Node> children = new ArrayList<>();
    private Node root = null;

    public TreeClass(int i) {
        root = new Node(i);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node> tmp = findBy(parent);
        if (tmp.isPresent()) {
            if (!(tmp.get().children.contains(child))) {
                tmp.get().add(new Node(child));
            }
        }
        return false;
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
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
