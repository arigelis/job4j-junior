package ru.job4j;

import java.util.Iterator;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                for (Iterator<Iterator<Integer>> it2 = it; it2.hasNext(); ) {
                    return it.hasNext();
                }
                return false;
            }

            @Override
            public Integer next() {
                for (Iterator<Iterator<Integer>> it1 = it; it1.hasNext(); ) {
                    Iterator iterator = it1.next();
                    for (Iterator it2 = iterator; it2.hasNext(); ) {
//                        Iterator ite12 = it2.next();


                    }
                }
                return null;
            }
        };
    }
}