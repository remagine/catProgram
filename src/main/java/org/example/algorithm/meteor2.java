package org.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class meteor2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringList = new ArrayList<>();
        String line;

        while ((line = bf.readLine()) != null){
            stringList.add(line);
        }

        String[] rs = stringList.get(0).split(" ");
        int r = Integer.parseInt(rs[0]); // 세로
        int s = Integer.parseInt(rs[1]); // 가로
        stringList.remove(0);

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
                result = c2 == '#';
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

}