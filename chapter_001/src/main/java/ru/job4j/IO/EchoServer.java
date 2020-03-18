package ru.job4j.IO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    if (!(str = in.readLine()).isEmpty()) {
                        str = str.replace("GET /?msg=", "").replace("HTTP/1.1", "");
                        if (str.contains("exit")) {
                            System.out.println("finish");
                            break;
                        }
                        out.write(("HTTP/1.1 200 " + str + "\r\n").getBytes());
                    }

                }
            }
        }
    }
}