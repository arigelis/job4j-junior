package ru.job4j.IO;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleChat {
    Scanner in;

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
            System.out.println("random answer");
            process(read(in));
        } else if (val.equalsIgnoreCase("stop")) {
            process(read(in));
        } else if (val.equalsIgnoreCase("end")) {
            System.out.println("finish");
            in.close();
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
}
