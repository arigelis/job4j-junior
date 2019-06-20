package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    SimpleArray simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray(5);
    }

    @Test
    public void add() {
        simpleArray.add("t1");
        simpleArray.add("t2");
        simpleArray.add(3);
        Integer result = (Integer) simpleArray.get(2);
        assertThat(3, is(result));
    }

    @Test
    public void set() {
        simpleArray.add("t1");
        simpleArray.add("t2");
        simpleArray.add(3);

        simpleArray.set(1, 4);
        Integer result = (Integer) simpleArray.get(1);
        assertThat(4, is(result));
    }

    @Test
    public void remove() {
        simpleArray.remove(0);
    }

    @Test
    public void get() {
        simpleArray.add("t1");
        simpleArray.add("t2");
        simpleArray.add(3);
        String result = (String) simpleArray.get(0);
        assertThat("t1", is(result));
    }

    @Test
    public void iterator() {
        Iterator iterator = simpleArray.iterator();
    }
}
