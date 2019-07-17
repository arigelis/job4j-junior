package ru.job4j.Set;

import ru.job4j.List.DynamicArray;

import java.util.Iterator;

public class SimpleSet<E> extends DynamicArray<E> {
    private int index = 0;

    @Override
    public E get(int i) throws ClassNotFoundException {
        throw new ClassNotFoundException();//кидаю exception т.к метод по сути  запрещён  в текущей реализации.
    }

    @Override
    public void add(E value) {
        boolean dup = false;
        Iterator<E> iterator = super.iterator();
        while (iterator.hasNext()) {
            if (value.equals(iterator)) {
                dup = true;
                break;
            }
        }
        if (!dup)
            super.add(value);
    }
}
