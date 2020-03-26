package ru.job4j.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    Scanner in;
    List<String> answers = new ArrayList<>();
    boolean stop;

    public ConsoleChat() {
        readAnswers();
    }

    public void start() {
        in = new Scanner(System.in);
        System.out.print("Start:");
        process(read(in));
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.start();
    }

    private void process(String val) {
        writeLog(val);
        if (val.equalsIgnoreCase("continue")) {
            stop = false;
            System.out.println(answers.get(Math.toIntExact(Math.round(Math.random() * answers.size()))));
            process(read(in));
        } else if (val.equalsIgnoreCase("stop")) {
            stop = true;
            process(read(in));
        } else if (val.equalsIgnoreCase("end")) {
            System.out.println("finish");
            in.close();
        } else {
            if (!stop) {
                System.out.println(answers.get(Math.toIntExact(Math.round(Math.random() * answers.size()))));
                process(read(in));
            }
        }
    }

    private void writeLog(String val) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("chatlog.txt"))) {
            out.write(val + System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String read(Scanner in) {
        return in.nextLine();
    }

    private void readAnswers() {
        try {
            File f = new File("data.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            System.out.println("Reading file using Buffered Reader");
            while ((readLine = b.readLine()) != null) {
                answers.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
