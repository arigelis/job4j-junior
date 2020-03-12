package ru.job4j.IO;

import javax.sql.rowset.Predicate;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void pack(File source, File target) {
        seekBy(source.getAbsolutePath(), ".xml");
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.read());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<File> seekBy(String root, String ext) {
        return new Search().files(root, (i -> !i.endsWith(ext)));
    }


    public static void main(String[] args) {
        new Zip().pack(new File("./chapter_001/pom.xml"), new File("./chapter_001/pom.zip"));
    }
}