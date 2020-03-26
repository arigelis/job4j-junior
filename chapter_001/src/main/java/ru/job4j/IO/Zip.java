package ru.job4j.IO;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    String dir, output, exc;

    public void parser(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-d")) {
                dir = args[i].replace("-d", "");
            } else if (args[i].contains("-o")) {
                output = args[i].replace("-o", "");
            } else if (args[i].contains("-e")) {
                exc = args[i].replace("-e", "");
            }
        }
    }

    public void pack() {
        List<File> filesList = seekBy(dir, exc);
        for (File file : filesList) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath())))) {
                zip.putNextEntry(new ZipEntry(output));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(dir))) {
                    zip.write(out.read());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<File> seekBy(String root, String ext) {
        return new Search().files(root, (i -> !i.endsWith(ext)));
    }
}