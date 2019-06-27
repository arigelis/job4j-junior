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

        if (indexRow < value.length && indexColumn < value[indexRow].length) {
            result = true;
        }
        return result;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int i = value[indexRow][indexColumn++];
        if (indexColumn == value[indexRow].length) {
            indexColumn = 0;
            indexRow++;
        }
        return i;
    }

    public void remove() {

    }
}

