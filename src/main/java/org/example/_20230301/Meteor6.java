package org.example._20230301;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Meteor6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
        String rowAndCol = bufferedReader.readLine();
        String rowStr = rowAndCol.split(" ")[0];
        String colStr = rowAndCol.split(" ")[1];

        int maxRow = Integer.parseInt(rowStr);
        int maxCol = Integer.parseInt(colStr);
        char[][] chars = new char[maxRow][maxCol];
        char[] cBuffer = new char[maxRow];

        while (true) {
            int len = bufferedReader.read(cBuffer);
            if (len == -1) {
                break;
            }
            for (int row = 0; row < maxRow; row++) {
                for (int col = 0; col < maxCol; col++) {
                    chars[row][col] = cBuffer[col];
                }
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (int col = 0; col < maxCol; col++) {
            int meteorRow = maxRow - 1;
            int landRow;
            for (int row = 0; row < maxRow; row++) {
                char c = chars[row][col];
                if (c == 'X') {
                    meteorRow = row;
                }
                if (c == '#') {
                    landRow = row;
                    minLength = Math.min(minLength, meteorRow - landRow);
                    break;
                }
            }
        }
        minLength--;


        // 운석의 사이즈를 측정한 후 그 사이즈 만큼 내리기
        for (int col = 0; col < maxCol; col++) {
            int meteorSize = 0;
            for (int row = 0; row < maxRow; row++) {
                char c = chars[row][col];
                if (c == '.') {
                    meteorSize = row + 1;
                    break;
                }
            }
            if (meteorSize != 0) {
                for (int row = 0; row < meteorSize - 1; row++) {
                    chars[row][col] = 'X';
                }
                for (int row = meteorSize; row < 2 * meteorSize - 1; row++) {
                    chars[row][col] = '.';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] cArray : chars) {
            for (char c : cArray) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
