package ru.job4j.IO;

import org.testng.annotations.Test;

public class ZipTest {

    @Test
    public void testPack() {
//        new Zip().pack(new File("./pom.xml"), new File("./pom.zip"));
        String[] args = new String[10];
        Zip a = new Zip();
        a.parser(args);
        a.pack();
    }
}