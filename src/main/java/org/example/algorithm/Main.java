package org.example.algorithm;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
//        nums[0] = 1;
//        nums[1] = 2;
//        nums[2] = 3;

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        for( int i : nums){
            System.out.println(i);
        }

        int[][] nums2 = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };

        System.out.println(nums2[1][1]);
        System.out.println(nums2[2][0]);

        for(int[] i : nums2){
            for(int num : i){
                System.out.print(num);
            }
            System.out.println();
        }


    }
}
