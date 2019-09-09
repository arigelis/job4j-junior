package ru.job4j.Set;

import ru.job4j.List.DynamicArray;

import java.util.Iterator;

public class SimpleSet<E> {
    private int index = 0;
    DynamicArray<E> a = new DynamicArray<>();

    public E get(int i) throws ClassNotFoundException {
        throw new ClassNotFoundException();//кидаю exception т.к метод по сути  запрещён  в текущей реализации.
    }

    boolean findDup(E value) {
        Iterator<E> iterator = a.iterator();
        boolean result = false;

        while (iterator.hasNext()) {
            if (value != null && value.equals(iterator.next())) {
                result = true;
                break;
            } else {
                if (value == null && iterator.next() == null) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public void add(E value) {
        if (!findDup(value)) {
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
