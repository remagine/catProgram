package org.example._20230219;

import java.io.*;
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
//        InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//        char[] chars = new char[3];
//        while(true){
//            int len = isr.read(chars);
//            if (len == -1){
//                break;
//            }
//            sb.append(chars,0,len);
//        }
//        System.out.println(sb);

        // 유니코드 utf-8 3 16 4
        // io 1. 인코딩/디코딩
        // 2. buffered 처리
        // 3. 자원의 해제
        // tcp 오류 제어 순서제어 ....
        // 한번 가져올때 많이 가져와야만 단점 보완이됨
        // 버퍼는 내가 받는 그릇 , 가져올때 그릇 2가지가 있네
        // 2의13승 8192 무난한 버퍼크기
        // 버퍼가 메모리 덜쓴다.
        // 버퍼가 8192로 쓰는이유는 8192 무난해서
        // 워커 한개당 8192잡힐 수 있다.
        // 메모리는 워커 쓰레드 갯수를 알아야
        // 파일 다운로드 업로드는 8192가 너무 작음
        // 스트리밍도 버퍼 크기가 큰게 좋음 2의 60승


        //가방처리
        BufferedInputStream bis = new BufferedInputStream(inputStream, 8192);
        InputStreamReader isr = new InputStreamReader(bis, StandardCharsets.UTF_8);
        char[] cBuffer = new char[3];
        while(true){
            int len = isr.read(cBuffer);
            if (len == -1){
                break;
            }
            sb.append(cBuffer,0,len);
        }
        System.out.println(sb);
    }
}
