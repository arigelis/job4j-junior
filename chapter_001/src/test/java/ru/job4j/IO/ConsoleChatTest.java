package ru.job4j.IO;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConsoleChatTest {

    @Test
    public void testStart() {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.start();
    }
}