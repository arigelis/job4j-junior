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
        return (getNextEven() >= 0 && value.length > index);
    }

    private int getNextEven() {
        int result = -1;
        for (int i = index; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        index = getNextEven();
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return value[index++];
    }
}
