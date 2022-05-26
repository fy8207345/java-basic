package org.example;

public class Test1 {

    static int cnt = 6;

    static {
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println("cnt =" + cnt);
    }

    static {
        cnt /= 3;
    }
}


