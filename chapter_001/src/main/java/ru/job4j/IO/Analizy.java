package ru.job4j.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Analizy {
    private class Node {
        private String status, time;

        @Override
        public String toString() {
            return status.concat(";").concat(time);
        }

        public Node(String status, String time) {
            this.status = status;
            this.time = time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    private LinkedList<Node> readSource(String source) {
        LinkedList<Node> linkedList = new LinkedList<>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(source), StandardCharsets.UTF_8);
            String line = br.readLine();
            while (line != null) {
                linkedList.add(new Node(line.split(";")[0], line.split(";")[1]));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linkedList;
    }

    private List<Node> handler(LinkedList<Node> linkedList) {
        if (linkedList == null) {
            return new LinkedList<>();
        }
        List<Node> unavailableEpisodes = new ArrayList<>();
        Iterator it = linkedList.iterator();
        boolean unavailable = false;
        for (Node node : linkedList) {
            if (!node.status.equalsIgnoreCase("200")) {
                if (unavailable) {
                    continue;
                } else {
                    unavailableEpisodes.add(new Node(node.time, ""));
                    unavailable = true;
                }
            } else {
                if (unavailable) {
                    unavailableEpisodes.get(unavailableEpisodes.size() - 1).setTime(node.time);
                    unavailable = false;
                }
            }
        }

        return unavailableEpisodes;
    }

    private void writeData(String target, List<Node> unavailableEpisodes) {
        try (
                PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (Node n : unavailableEpisodes) {
                out.println(n.toString());
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public void unavailable(String source, String target) {
        LinkedList<Node> linkedList = readSource(source);//читаем
        List<Node> unavailableEpisodes = handler(linkedList);//обрабатываем
        writeData(target, unavailableEpisodes);//пишем
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}