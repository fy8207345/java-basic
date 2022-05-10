package com.fy.java;

public class Solution {
    /**
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater (int[] arr){
        // write code here
        int prevMax = -1;
        long total = 0;
        long period = 0;
        for(int i=0;i<arr.length;i++){
            if(prevMax == -1){
                prevMax = arr[i];
                continue;
            }
            int current = arr[i];
            if(current > prevMax){

            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,1,3,5,2,4};
        long result = solution.maxWater(arr);
        System.out.println(result);
    }
}
