package com.fy.java;

import java.util.Scanner;
public class Main1 {

    private static final int EMPTY_BOTTLES_EXCHANGER = 3;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        while(value != 0){
            if(value >= 1 && value <= 100){
                int drinked = canculate(value);
                System.out.println(drinked);
            }else{
                throw new IllegalArgumentException("请输入1-100直接的整数");
            }
            value = scanner.nextInt();
        }
    }

    public static int canculate(int drinks){
        int emptyBottles = 0;
        int borrow = 0;
        int leftDrinks = drinks;
        int result = 0;
        while(true){
            if((leftDrinks + emptyBottles) >= EMPTY_BOTTLES_EXCHANGER){
                int exchanged = (leftDrinks + emptyBottles) / EMPTY_BOTTLES_EXCHANGER;
                emptyBottles += exchanged;
                leftDrinks -= exchanged * EMPTY_BOTTLES_EXCHANGER;
                result += exchanged;
            } else if(((leftDrinks + emptyBottles)) == EMPTY_BOTTLES_EXCHANGER - 1){
                borrow++;
                emptyBottles++;
                result++;
            }else {
                break;
            }
        }
        if(borrow > 0){
            result -= borrow;
        }
        return result;
    }
}