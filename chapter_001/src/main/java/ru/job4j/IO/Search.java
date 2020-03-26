package ru.job4j.IO;

import ru.job4j.Tree.Node;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

//import sun.reflect.generics.tree.Tree;

public class Search {
    List<File> files(String parent, Predicate<String> condition) {
        File file = new File(parent);
        ArrayList<File> result = new ArrayList<>();

        Queue<File> data = new LinkedList<>();
        data.offer(file);
        while (!data.isEmpty()) {
            File el = data.poll();
            for (File tmpFile : el.listFiles()) {
                if (!condition.test(tmpFile.getName())) {
                    continue;
                } else if (tmpFile.isDirectory()) {
                    data.addAll(Arrays.asList(tmpFile.listFiles()));
                } else {
                    result.add(tmpFile);
                }
            }
        }
        return result;
    }
}
