package ru.job4j.Set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddOneThenNullThenTwoAndOneOutputNoDuplicates() {
        SimpleSet simpleSet = new SimpleSet();
        simpleSet.add(1);
        simpleSet.add(null);
        simpleSet.add(2);
        simpleSet.add(1);
        assertThat(simpleSet.toString(), is("1,2,null"));
    }
}