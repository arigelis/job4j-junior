package ru.job4j.List;

import org.junit.Test;

import static org.testng.Assert.*;

public class SimpleQueueTest {

    @Test
    public void testSimpleQueue() {
        SimpleQueue simpleQueue = new SimpleQueue();
        simpleQueue.push(new String("1"));
        simpleQueue.push(new String("2"));

        System.out.println(simpleQueue.poll());//вытащит "1"

        simpleQueue.push(new String("3"));

        System.out.println(simpleQueue.poll());//вытащит "2"
    }

}