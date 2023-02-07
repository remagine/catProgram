package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static class RandomFile{
        private String filePath;

        {
            filePath = Math.random() + ".txt";
        }
    }
    public static void main(String[] args) throws IOException {
        /*InputStream inputStream = System.in;
        byte[] buffer = new byte[2];
        String s = "";

        // int len = -1
        while(true){
            int len = inputStream.read(buffer);
            if(len == -1){
                break;
            }
            //System.out.print(new String(buffer, 0, len, StandardCharsets.UTF_8));
            s += new String(buffer, 0 , len , StandardCharsets.UTF_8);
        }
        System.out.println(s);*/

        InputStream inputStream = System.in;
        byte[] buffer = new byte[2048];

        while(true){
            int len = inputStream.read(buffer);
            String message = new String(buffer, 0, len, StandardCharsets.UTF_8).trim();
            String[] arrayString = message.split(" ");

            RandomFile randomFile = new RandomFile();

            String program = arrayString[0];
            if(!"cat".equals(program)){
                System.out.println("command not found: " + program);
                continue;
            }

            if(arrayString.length < 2){
                System.out.println("type fileNames");
                continue;
            }

            for (int i = 1; i < arrayString.length; i++) {
                String fileName = arrayString[i];
                printFileContent(fileName);
                printFileContent(randomFile.filePath);
            }
        }
    }

    private static void printFileContent(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        boolean exist = Files.exists(path);
        System.out.println("FileName :: " + path.getFileName());
        if(exist){
            List<String> texts = Files.readAllLines(path);
            texts.forEach(System.out::println);

            // 스트리밍 코딩 습관
            // java io >
            // nio 는 채널? 스트리밍을 처리할 기본도구
            // \n 기준 /n/r


        }

        if(!exist){
            System.out.println("file not found!");
        }
    }
}