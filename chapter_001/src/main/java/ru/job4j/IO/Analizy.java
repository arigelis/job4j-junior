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

    public void unavailable(String source, String target) {
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


        List<Node> unavailableEpisodes = new ArrayList<>();
        Iterator it = linkedList.iterator();
        boolean unavailable = false;
        while (it.hasNext()) {
            Node tmp = (Node) it.next();
            if (!tmp.status.equalsIgnoreCase("200")) {
                if (unavailable) {
                    continue;
                } else {
                    unavailableEpisodes.add(new Node(tmp.time, ""));
                    unavailable = true;
                }
            } else {
                if (unavailable) {
                    unavailableEpisodes.get(unavailableEpisodes.size() - 1).setTime(tmp.time);
                    unavailable = false;
                }
            }
        }

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

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}