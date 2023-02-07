package org.example.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        String s = "/Users/pololo/Documents/test2.txt";
        Path path = Paths.get(s);
//        StringBuilder message = new StringBuilder();
//        for (int i = 0; i < 1000; i++) {
//
//            message.append("Hello").append(i).append("\n");
//        }
//        Files.writeString(path,message.toString());
//        System.out.println(message);
        List<String> texts = Files.readAllLines(path);
        // streaming 처리
//        for(String i : texts){
//            System.out.println(i);
//        }

        InputStream inputStream = new FileInputStream(s);
        byte[] buffer = new byte[2];
        StringBuilder sb = new StringBuilder();

        System.out.println(Arrays.toString(buffer));
        System.out.println(Arrays.toString(buffer));
//        char c = (char) buffer[0];
//        System.out.println(c);
        while(true){
            int len = inputStream.read(buffer);

            for(byte b : buffer){

                char c =  (char) b;
                if(c == '\n'){
                    System.out.println(sb);
                    sb.setLength(0);
                    break ;
                }
                sb.append(c);
            }

            if(len == -1){
                break;
            }
        }
//        System.out.println(texts);
    }
}
