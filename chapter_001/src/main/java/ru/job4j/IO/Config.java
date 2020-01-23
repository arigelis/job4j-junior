package ru.job4j.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tmp = out.toString();

        String[] tmpArray = tmp.split("\r\n");
        for (int i = 0; i < tmpArray.length; i++) {
            String[] currItem = tmpArray[i].split("=");
            if (!currItem[1].isEmpty()) {
                values.put(currItem[0], currItem[1]);
            }
        }
    }

    public String value(String key) {
//        throw new UnsupportedOperationException("Don't impl this method yet!");
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("./app.properties"));
    }
}