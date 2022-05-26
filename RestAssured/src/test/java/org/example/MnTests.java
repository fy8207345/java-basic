package org.example;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class MnTests {

    @Test
    void name() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int m = n, i = 0;
        while(m-- > 0) {
            arr[i++] = sc.nextInt();
        }
        int maxSoFar = Integer.MIN_VALUE, maxCur = 0;
        for(i = 0; i < n; i++) {
            maxCur = Math.max(maxCur + arr[i], arr[i]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        System.out.println(maxSoFar);
    }
}
