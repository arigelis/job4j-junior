package ru.job4j.Set;

import ru.job4j.List.DynamicArray;

import java.util.Iterator;

public class SimpleSet<E> {
    private int index = 0;
    DynamicArray<E> a = new DynamicArray<>();

    public E get(int i) throws ClassNotFoundException {
        throw new ClassNotFoundException();//кидаю exception т.к метод по сути  запрещён  в текущей реализации.
    }

    public void add(E value) {
        boolean dup = false;
        Iterator<E> iterator = a.iterator();

        while (iterator.hasNext()) {
            if (value == iterator.next()) {
                dup = true;
                break;
            }
        }
        if (!dup) {
            a.add(value);
            index++;
        }
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        Iterator tmpIterator = a.iterator();
        for (int i = 0; i <= index; i++) {
            E a = (E) tmpIterator.next();
            if (a != null) {
                tmp.append(a.toString());
            } else {
                tmp.append("null");
            }
            if (i != index) {
                tmp.append(",");
            }
        }
        return tmp.toString();
    }
}
