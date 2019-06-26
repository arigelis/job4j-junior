package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class JaggerArrayIterator implements Iterator {
    int[][] value;// = {{1, 2}, {3, 4}};
    int indexRow = 0;
    int indexColumn = 0;

    public JaggerArrayIterator(int[][] value) {
        this.value = value;
    }

    public boolean hasNext() {
        boolean result = false;
        if (indexColumn >= (value.length - 1) && indexRow >= value[indexColumn].length) {
            result = false;
        } else if (indexRow < (value[indexColumn].length)) {
            result = true;
        } else {
            indexRow = 0;
            indexColumn++;
            if (indexRow > (value[indexColumn].length - 1)) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return value[indexColumn][indexRow++];
    }

    public void remove() {

    }
}

