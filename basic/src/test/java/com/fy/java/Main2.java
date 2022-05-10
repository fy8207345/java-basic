package com.fy.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while(true){
            value = scanner.nextInt();
            if(value <= 0){
                throw new IllegalArgumentException("个数不能小于1");
            }
            Set<Integer> values = new HashSet<>(value);
            int count = 0;
            while (count < value){
                values.add(scanner.nextInt());
                count++;
            }
            values.stream()
                    .sorted()
                    .forEach(System.out::println);
            if(!scanner.hasNext()){
                break;
            }
        }
    }
}
