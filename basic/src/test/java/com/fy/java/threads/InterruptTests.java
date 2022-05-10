package com.fy.java.threads;

import java.util.concurrent.TimeUnit;

public class InterruptTests {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().interrupt();
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        thread.join();

        System.out.println("end");
    }
}
