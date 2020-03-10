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
        ArrayList<File> result = new ArrayList<>();

        Node<File> fff = new Node<>(file);
        Queue<Node<File>> data = new LinkedList<>();
        data.offer(fff);
        while (!data.isEmpty()) {
            Node<File> el = data.poll();
            for (File tmpFile : el.getValue().listFiles()) {
                if (tmpFile.isDirectory() || !condition.test(tmpFile.getName())) {
                    continue;
                } else {
                    result.add(tmpFile);
                }
            }
        }
        return result;
    }
}
