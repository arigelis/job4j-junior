package ru.job4j.IO;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AnalizyTest {

    @Test
    public void testUnavailable() {
        Analizy analizy = new Analizy();
        analizy.unavailable("stacktrace.csv", "result.csv");
    }
}