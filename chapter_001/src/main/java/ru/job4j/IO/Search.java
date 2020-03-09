package ru.job4j.IO;

import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Search {
    List<File> files(String parent, Predicate<String> condition) {
        File file = new File(parent);
        return Arrays.stream(file.listFiles()).filter(e -> !e.isDirectory()).filter(condition).collect(Collectors.<File>toList());
    }
}
