package com.fy.java.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Locks {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    exchanger.method1();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    exchanger.method2();
                }
            }
        }).start();
    }

    private static class Exchanger{
        private Lock lock = new ReentrantLock();

        public void method1(){
            try {
                lock.lock();
                log.info("method1 begin");
                TimeUnit.SECONDS.sleep(3);
                log.info("method1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void method2(){
            try {
                lock.lock();
                log.info("method2 begin");
                TimeUnit.SECONDS.sleep(3);
                log.info("method2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
