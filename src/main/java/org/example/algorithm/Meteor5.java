package org.example.algorithm;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Meteor5 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream2 = new ByteArrayInputStream(("5 6\n" +
                ".XXXX.\n" +
                "...X..\n" +
                "......\n" +
                "#..###\n" +
                "######").getBytes(StandardCharsets.UTF_8));
        InputStream inputStream = new ByteArrayInputStream(("9 7\n" +
                "XXX.XXX\n" +
                "X.XXX.X\n" +
                "X..X..X\n" +
                "X.....X\n" +
                ".......\n" +
                ".#...#.\n" +
                ".##.##.\n" +
                ".#####.\n" +
                "#######").getBytes(StandardCharsets.UTF_8));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(inputStream)));

        String line1 = bufferedReader.readLine();
        String[] rowAndCol = line1.split(" ");
        int maxRow = Integer.parseInt(rowAndCol[0]);
        int maxCol = Integer.parseInt(rowAndCol[1]);

        char[][] chars = new char[maxRow][maxCol];


        for (int row = 0; row < maxRow; row++) {
            String line = bufferedReader.readLine();
            for (int col = 0; col < maxCol; col++) {
                chars[row][col] = line.charAt(col);
            }
        }

        for(char[] c : chars){
            System.out.println(Arrays.toString(c));
        }

        int length = Integer.MAX_VALUE;
        for(int col = 0; col < maxCol; col++){
            int xRow = -1;
            for(int row = 0; row < maxRow; row++){
                char c = chars[row][col];
                if(c == 'X'){
                    xRow = row;
                }
                if(c == '#' && xRow != -1){
                    length = Math.min(length, row - xRow);
                }
            }
        }
        length--;

        System.out.println(length);

        //1번 방법
        for(int row = maxRow -1; row >= 0; row--){
            for(int col = 0; col < maxCol; col++){
                char c = chars[row][col];
                if(c == 'X'){
                    chars[row][col] = '.';
                    chars[row+length][col] = 'X';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char[] cs : chars){
            for (char c : cs){
                sb.append(c);
            }
            sb.append('\n');
        }

        System.out.println(sb);

        //2번 방 # 앞이 .인지 체크후 x를 렝스만큼 내리기
    }
}
