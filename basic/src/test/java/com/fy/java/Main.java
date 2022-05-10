package com.fy.java;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String hexString = scanner.nextLine().replace("0x", "");
            Integer integer = Integer.parseInt(hexString, 16);
            System.out.println(integer);
        }
    }
}
