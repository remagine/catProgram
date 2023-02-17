package org.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class meteor4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String rs = bf.readLine();
        int r = Integer.parseInt(rs.split(" ")[0]);
        int s = Integer.parseInt(rs.split(" ")[1]);
        char[][] chars = new char[r][s];

        for (int i = 0; i < r; i++) {
            String line = bf.readLine();
            for (int j = 0; j < s; j++) {
                chars[i][j] = line.charAt(j);
            }
        }
        bf.close();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }

        // 1. 최소 충돌거리를 찾는다.
        int length = Integer.MAX_VALUE;

        for (int i = 0; i < r; i++) {
            int rX = 0;
            int rL = r - 1;
            for (int j = 0; j < s; j++) {
                char x = chars[i][j];
                if (x == 'X') {
                    rX = i;
                    for (int k = 0; k < r; k++) {
                        char l = chars[k][j];
                        if (l == '#') {
                            rL = Math.min(rL, k);
                        }
                    }
                    length = Math.min(rL - rX, length);
                }
            }
        }
        length--; // 실제 움직여야할 거리

        // 운석부분을 r + length -1
        // 기존 운석부분은 공기 . 로 치환
        // 기존 공기부분을 C로 치환
        // C를 전부 X로 치환
        /*for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                char x = chars[i][j];
                if (x == 'X') {
                    chars[i][j] = '.';
                    chars[i + length][j] = 'C';
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                char x = chars[i][j];
                if (x == 'C') {
                    chars[i][j] = 'X';
                }
            }
        }*/

        // 운석의 밑에서부터 변환하기
        for (int i = r - 1; i >= 0; i--) {
            for (int j = 0; j < s; j++) {
                char x = chars[i][j];
                if (x == 'X') {
                    chars[i][j] = '.';
                    chars[i + length][j] = 'X';
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
