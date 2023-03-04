package org.example._20230301;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Stream {
    public static void main(String[] args) throws IOException {
        String text = "Hello world\n" +
                "안녕하세요. 오택상입니다.\n" +
                "hi my name is 택상";


        byte[] eucBytes = text.getBytes("euc-kr");
        String eucText;

        String path = "test/euc_kr.txt";
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);

        fileOutputStream.write(eucBytes);

        path = "test/utf-8.txt";
        File utf8File = new File(path);

        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream2 = new FileOutputStream(utf8File);
        byte[] buffer = new byte[3];

        while (true) {
            int len = fileInputStream.read(buffer);
            if (len == -1) {
                break;
            }
            eucText = new String(buffer, 0, len, "euc-kr");
            fileOutputStream2.write(eucText.getBytes(StandardCharsets.UTF_8));
        }


    }
}
