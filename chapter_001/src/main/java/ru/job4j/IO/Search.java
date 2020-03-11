package ru.job4j.IO;

import ru.job4j.Tree.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

//import sun.reflect.generics.tree.Tree;

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
