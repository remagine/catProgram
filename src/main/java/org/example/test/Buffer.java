package org.example.test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Buffer {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = openInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        char[] cBuffer = new char[2];

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int len = inputStreamReader.read(cBuffer);
            if (len == -1) {
                break;
            }
            stringBuilder.append(cBuffer);
        }
        System.out.println(stringBuilder);
    }

    private static InputStream openInputStream() throws FileNotFoundException {
        // message
        String message = "Hello world 안녕하세요!";
        // message byte 화
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        // inputstream 준비
        InputStream inputStream = new FileInputStream("build.gradle");
        return  inputStream;
    }
}
