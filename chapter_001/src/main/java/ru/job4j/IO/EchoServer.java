package ru.job4j.IO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean exit = false;
            while (true) {
//                if (exit) break;
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str, resp = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        resp = resp.concat(str);
                        if (str.contains("exit")) {
                            exit = true;
                            str = "finish";
                            break;
                        }
                    }

//                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                    out.write(resp.getBytes());
                }
            }
        }
    }
}