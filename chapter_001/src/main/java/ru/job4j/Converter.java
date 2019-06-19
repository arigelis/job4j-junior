package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator indexIt;
    int index = 0;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        indexIt = it.next();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (indexIt.hasNext()) {
                    result = true;
                } else if (it.hasNext()) {
                    indexIt = it.next();
                    index = 0;
                    result = true;
                } else {
                    result = false;
                }
                return result;
            }

            @Override
            public Integer next() {
                if (indexIt.hasNext()) {
                    Integer result = 0;
                    for (Iterator it2 = indexIt; it2.hasNext(); ) {
                        result = (Integer) it2.next();
                        index++;
                        break;
                    }
                    return result;
                } else if (it.hasNext()) {
                    indexIt = it.next();
                    index = 0;
                    return (Integer) indexIt.next();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}