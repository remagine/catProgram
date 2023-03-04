package org.example._20230301;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Stream3 {
    public static void main(String[] args) throws IOException {
        String path = "test/euc_kr.txt";
        File eucFile = new File(path);
        FileInputStream fileInputStream = new FileInputStream(eucFile);

        // InputStreamReader는 inputStream을 읽어 char[]을 반환한다.
        // euc-kr 파일을 읽어 char[]을 받은후
        // 그것을 utf-8 파일에 저장하자
        InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(fileInputStream), "euc-kr");
        String utf8Path = "test/utf_8_3.txt";
        File utf8File = new File(utf8Path);
        FileOutputStream fileOutputStream = new FileOutputStream(utf8File);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);

        char[] buffer = new char[3];

        while (true) {
            int len = inputStreamReader.read(buffer);
            if (len == -1) {
                break;
            }
            outputStreamWriter.write(buffer,0,len);
        }
        outputStreamWriter.close();
        inputStreamReader.close();
    }
}
