package ru.job4j.IO;

import ru.job4j.Tree.Node;
import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Search {
    List<File> files(String parent, Predicate<String> condition) {
        File file = new File(parent);

        Node<File> fff = new Node<>(file);
        Queue<Node<File>> data = new LinkedList<>();
        data.offer(fff);

        while (!data.isEmpty()) {
            Node<File> el = data.poll();
            data.addAll(el.children);
        }
        return (List<File>) data.stream().filter(e -> !e.getValue().isDirectory()).filter(e -> condition.test(e.getValue().getName()));
    }
}
