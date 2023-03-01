package org.example._20230301;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Meteor8 {
    public static void main(String[] args) throws IOException {
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


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(inputStream,8192)));
        String rowAndCol = bufferedReader.readLine();
        String rowStr = rowAndCol.split(" ")[0];
        String colStr = rowAndCol.split(" ")[1];

        int maxRow = Integer.parseInt(rowStr);
        int maxCol = Integer.parseInt(colStr);
        char[][] chars = new char[maxRow][maxCol];

        for (int row = 0; row < maxRow; row++) {
            String line = bufferedReader.readLine();
            for (int col = 0; col < maxCol; col++) {
                chars[row][col] = line.charAt(col);
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (int col = 0; col < maxCol; col++) {
            int meteorRow = -1;
            for (int row = 0; row < maxRow; row++) {
                char c = chars[row][col];
                if (c == 'X') {
                    meteorRow = row;
                }
                if (meteorRow != -1 && c == '#') {
                    minLength = Math.min(minLength, row - meteorRow);
                    break;
                }
            }
        }
        minLength--;

        // 성공한 방식
        for (int row = maxRow - 1; row >= 0; row--) {
            for (int col = 0; col < maxCol; col++) {
                char c = chars[row][col];
                if (c == 'X') {
                    chars[row][col] = '.';
                    chars[row + minLength][col] = 'X';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] cArray : chars) {
            for (char c : cArray) {
                sb.append(c);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
