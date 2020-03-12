package ru.job4j.IO;

import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class ZipTest {

    @Test
    public void testPack() {
        new Zip().pack(new File("./pom.xml"), new File("./pom.zip"));

    }
}