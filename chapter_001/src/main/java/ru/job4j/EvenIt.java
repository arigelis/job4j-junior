package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator {
    int[] value;
    int index = 0;

    public EvenIt(final int[] numbers) {
        this.value = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                index = i;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return value[index++];
    }
}
