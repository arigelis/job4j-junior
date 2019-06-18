package ru.job4j;

import java.util.Iterator;

public class JaggerArrayIterator implements Iterator {
    int[] value;// = {{1, 2}, {3, 4}};
    int index = 0;

    public JaggerArrayIterator(int[][] value) {
        int initiar = 0;
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                initiar++;
            }
        }
        int[] tmp = new int[initiar];
        int counter = 0;
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                tmp[counter] = value[i][j];
                counter++;
            }
        }
        this.value = tmp;
    }

    public boolean hasNext() {
        return value.length > index;
    }

    public Integer next() {
        return value[index++];
    }

    public void remove() {

    }
}

