package org.example._20230219;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        // inputstream 읽는 거부터
        // 이진코드를 다루는 api stream
        // Io.Stream 처리를 해볼것
        // 메모리에 있는 정보를 스트림화 할 수 있다
        // 바이트어레이 인풋스트림

        // 바이트배열로 인풋을 받는다.
        // 메모리 설정한 데이터를 바로 다룰 수 있다.
        // 문자열을 바이
        String h = "Hello world 안녕ㅁa하세요";
        byte[] bytes = h.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(bytes);
        byte[] buffer = new byte[3];
//        int len = inputStream.read(buffer);
//        String s = new String(buffer, 0, len, StandardCharsets.UTF_8);
//        System.out.println(s);


        StringBuilder sb = new StringBuilder();
//        while (true) {
//            int length = inputStream.read(buffer);
//            if (length == -1) {
//                break;
//            }
//            sb.append(new String(buffer, 0, length, StandardCharsets.UTF_8));
//        }
        InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        char[] chars = new char[3];
        while(true){
            int len = isr.read(chars);
            if (len == -1){
                break;
            }
            sb.append(chars,0,len);
        }
        System.out.println(sb);

        // 유니코드 utf-8 3 16 4
    }
}
