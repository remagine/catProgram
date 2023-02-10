package org.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class meteor {
    static class Cord{
        int r; // 세로
        int s; // 가로

        public Cord(int r, int s) {
            this.r = r;
            this.s = s;
        }

        public int getR() {
            return r;
        }

        public int getS() {
            return s;
        }

        public void setR(int r) {
            this.r = r;
        }

        public void setS(int s) {
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bf.readLine().split("\n");
        String[] rs = lines[0].split(" ");
        int r = Integer.parseInt(rs[0]); // 세로
        int s = Integer.parseInt(rs[1]); // 가로
        List<Cord> xCordList = new ArrayList<>();
        List<Cord> sCordList = new ArrayList<>();
        System.out.println(Arrays.toString(lines));
        System.out.println(Arrays.toString(rs));

        for (int i = 1; i < lines.length; i++) {
            char[] l = lines[i].toCharArray();
            for (int j = 0; j < l.length; j++) {
                if(l[j] == 'X'){
                    xCordList.add(new Cord(i,j));
                }
                if(l[j] == '#') break;
            }
        }

        System.out.println(xCordList);



        for (int i = 1; i < lines.length; i++) {
            char[] l = lines[i].toCharArray();
            for (int j = 0; j < l.length; j++) {
                if(l[j] == '#'){
                    sCordList.add(new Cord(i,j));
                }
            }
        }

        System.out.println(sCordList);
    }
}
