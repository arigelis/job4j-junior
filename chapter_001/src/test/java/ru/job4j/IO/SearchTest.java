package ru.job4j.IO;

import org.testng.annotations.Test;

import java.util.function.Predicate;

import static org.testng.Assert.*;

public class SearchTest {

    @Test
    public void testFiles() {
        Search search = new Search();
        search.files(System.getProperty("java.io.tmpdir"), new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        });
    }
}