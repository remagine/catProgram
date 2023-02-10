package org.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class meteor1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> stringList = new ArrayList<>();
        List<String> newList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringList.add(line);
        }

        String rs = stringList.get(0);
        String[] rsArray = rs.split(" ");
        int r = Integer.parseInt(rsArray[0]);
        int s = Integer.parseInt(rsArray[1]);

        for (int i = 1; i < stringList.size(); i++) {
            String current = stringList.get(i);
            String next = stringList.get(i+1);


            String tmp = current;
            String result = changeString(current);
            newList.add(result);

        }

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
