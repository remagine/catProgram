package org.example.algorithm;

public class Main2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int[][] nums2 = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };




        for (int row = 0; row < nums2.length; row++) {
            int[] n = nums2[row];
            for (int col = 0; col < n.length; col++) {
                System.out.print(nums2[col][row]);
            }
            System.out.println();
        }



    }
}
