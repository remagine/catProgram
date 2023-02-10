package org.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class meteor3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringList = new ArrayList<>();
        String line;

        while ((line = bf.readLine()) != null){
            System.out.println(line);
            stringList.add(line);
            System.out.println(stringList);
        }

        bf.close();
        System.out.println(stringList.size());


        String[] rs = stringList.get(0).split(" ");
        int r = Integer.parseInt(rs[0]); // 세로
        int s = Integer.parseInt(rs[1]); // 가로
        stringList.remove(0);

        System.out.println(r);
        System.out.println(s);

        List<String> newList = new ArrayList<>();
        List<String> meteor = new ArrayList<>();
        int meteorR = 0;
        List<String> land = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i++) {
            String current = stringList.get(i);
            if(current.contains("X")){
                meteor.add(current);
                continue;
            }
            meteorR = i;
            break;
        }

        int collisionR = 0;
        for (int i = meteorR; i < stringList.size() ; i++) {
            String lastMeteor = stringList.get(meteorR);
            String current = stringList.get(i);
            if(checkCollision(lastMeteor, current)){
                collisionR = i;
                break;
            }
        }

        for (int i = collisionR; i < stringList.size(); i++) {
            String current = stringList.get(i);
            if(current.contains("#")){
                land.add(current);
            }
        }

        // meteor combine land
        land.addAll(meteor);
        String prev = "";
        for (String l : land) {
            String current = l;
            String temp = current;
            if(prev.length() == 0) prev = current;
            String result = mixString(current, prev);
            prev = temp;
            newList.add(result);


        }

        // 이중포문문
       for(int i = meteor.size() -1 ; i >=0 ; i--){
           // 운석 마지막 줄
           String meteorLine = meteor.get(i);
           for (int j = 0; j < land.size(); j++) {
               String landLine = land.get(j);
               if(checkCollision(meteorLine, landLine)){
                   String result = changeString(meteorLine);
                   newList.add(result);
               }
           }
       }

        System.out.println(newList);


        for (int i = 1; i < stringList.size(); i++) {
            String current = stringList.get(i);
            String next = stringList.get(i+1);
            String tmp = current;

            if(!checkCollision(current, next)){
                String result = changeString(current);
                newList.add(result);
            }
        }
    }

    static boolean checkCollision(String c, String n){
        boolean result = false;
        for (int i = 0; i < c.length(); i++) {
            char c1 = c.charAt(i);
            if(c1 == 'X'){
                char c2 = n.charAt(i);
                result = c2 == '#' || c2 == 'X';
            }
        }
        return result;
    }

    static String changeString(String s) {
        StringBuilder result = new StringBuilder();
        s.chars().forEach(c -> {
            switch (c) {
                case '.':
                    result.append('.');
                    break;
                case 'X':
                    result.append('.');
                    break;
                case '#':
                    result.append('#');
                    break;
                default:
                    // do nothing
                    break;
            }
        });
        return result.toString();
    }

    static String mixString(String cur, String prev) {
        StringBuilder result = new StringBuilder();
        cur.chars().forEach(c -> {
            prev.chars().forEach(p->{
                if (p == '.') {
                    result.append(c);
                } else {
                    result.append(p);
                }
            });

        });
        return result.toString();
    }

}