package org.example._20230219;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Cat {
    public static void main(String[] args) throws IOException {
        // cat 파일 > 출력명령
        String path = "test/pathTest.txt";
        InputStream inputStream = new FileInputStream(path);
//        InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//        char[] chars = new char[3];
//
//        OutputStream outputStream = System.out;
//        StringBuilder sb = new StringBuilder();
//        while(true){
//            int len = isr.read(chars);
//            if (len == -1){
//                break;
//            }
//            String s = new String(chars,0,len);
//            byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
//            outputStream.write(bytes);
////            sb.append(chars,0,len);
//        }

        // 임의로 에러 발생해보기
        OutputStream os = System.out;
        byte[] buffer = new byte[3];
        while (true) {
            int len = inputStream.read(buffer);
            if (len == -1) {
                break;
            }
            String s = new String(buffer,0,len,"Euc-kr");
            os.write(s.getBytes(StandardCharsets.UTF_8));
        }
        os.flush();
        // outpustream buffer담아서 출력하고 플러쉬하기
    }
}
