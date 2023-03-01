package org.example._20230301;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Meteor7 {
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
            int meteorRow = -1;
            int landRow;
            for (int row = 0; row < maxRow; row++) {
                char c = chars[row][col];
                if (c == 'X') {
                    meteorRow = row;
                }
                if (c == '#' && meteorRow != -1) {
                    landRow = row;
                    minLength = Math.min(minLength, meteorRow - landRow);
                    break;
                }
            }
        }
        minLength--;

        //2번 방 # 앞이 .인지 체크후 x를 렝스만큼 내리기 > 더 오래 걸릴듯?
        for (int col = maxCol - 1; col >= 0; col--) {
            for (int row = 0; row < maxRow; row++) {
                char c = chars[row][col];
                if (c == '.') {

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
