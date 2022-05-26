package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int m = n, i = 0;
        while(m-- > 0) {
            arr[i++] = sc.nextInt();
        }
        int maxSoFar = arr[0], maxCur = arr[0];
        for(i = 1; i < n; i++) {
            maxCur = Math.max(maxCur + arr[i], arr[i]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        System.out.println(maxSoFar);
    }
}
