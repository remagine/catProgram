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

        while ((line = bf.readLine()) != null && !line.equals("")) {
            stringList.add(line);
        }

        bf.close();

        String[] rs = stringList.get(0).split(" ");
        int r = Integer.parseInt(rs[0]); // 세로
        int s = Integer.parseInt(rs[1]); // 가로
        stringList.remove(0);
        List<String> newList = new ArrayList<>();
        List<String> meteor = new ArrayList<>();
        List<String> land = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i++) {
            String current = stringList.get(i);
            if (current.contains("X")) {
                meteor.add(current);

            } else {
                land.add(current);
            }

        }
        System.out.println(meteor);
        System.out.println(land);


        //충돌하면 랜드를 붙인다.
        // 충돌하지 않으면 합친다.
        // 합친 후 붙인다. 합친걸 기존 어레이에 넣는다.
        // 만일

        for (int i = meteor.size() - 1; i >= 0; i--) {
            String meteorLine = meteor.get(i);
            for (int j = 0; j < land.size(); j++) {
                String landLine = land.get(j);


                if (landLine.contains("X")) {
                    String result = mixString(meteorLine, landLine);
                    newList.add(0, result);
                    break;
                } else if (checkCollision(meteorLine, landLine)) {
                    newList.add(landLine);
                } else {
                    String result = mixString(meteorLine, landLine);
                    land.set(j, result);
                    newList.add(result);
                }
            }
        }

        newList.forEach(
                System.out::println
        );


        /*System.out.println(mixString("XXX.XXX","X#XXX#X"));*//**/
    }

    static boolean checkCollision(String c, String n) {
        boolean result = false;
        for (int i = 0; i < c.length(); i++) {
            char c1 = c.charAt(i);
            if (c1 == 'X') {
                char c2 = n.charAt(i);
                result = c2 != '.';
            }
        }
        return result;
    }

    static String mixString(String cur, String prev) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cur.length(); i++) {
            char c = cur.charAt(i);
            char p = prev.charAt(i);
            if (p == '.') {
                result.append(c);
            } else {
                result.append(p);
            }
        }

        /*cur.chars().forEach(c -> {
            prev.chars().forEach(p->{
                if (p == '.') {
                    result.append(c);
                } else {
                    result.append(p);
                }
            });
        });*/
        return result.toString();
    }

}