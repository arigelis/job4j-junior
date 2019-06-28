package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator indexIt;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        indexIt = it.next();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                if (!indexIt.hasNext()) {  // если текущий не содержит элементов запустим цикл
                    while (it.hasNext() && !indexIt.hasNext()) { // пока в итераторе итераторов есть итераторы и у текущего нет элементов
                        indexIt = it.next(); // будем присваивать текущему новый итератор из итератора итераторов
                    }
                }
                return indexIt.hasNext(); //возвращаем есть ли элементы в итераторе
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return (Integer) indexIt.next();
                }
//
//                if (indexIt.hasNext()) {
//                    Integer result = 0;
//                    for (Iterator it2 = indexIt; it2.hasNext(); ) {
//                        result = (Integer) it2.next();
//                        index++;
//                        break;
//                    }
//                    return result;
//                } else if (it.hasNext()) {
//                    indexIt = it.next();
//                    index = 0;
//                    return (Integer) indexIt.next();
//                } else {
//                    throw new NoSuchElementException();
//                }
            }
        };
    }
}