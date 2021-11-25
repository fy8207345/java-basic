package com.fy.java.threads;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class WaitAndInterrupt {

    @Test
    public void name() throws InterruptedException {
        Object monitor = new Object();

        MyRunnable myRunnable1 = new MyRunnable(monitor);
        MyRunnable myRunnable2 = new MyRunnable(monitor);

        Thread thread1 = new Thread(myRunnable1, "thread-1");
        Thread thread2 = new Thread(myRunnable2, "thread-2");
        myRunnable1.setThread(thread2);
        myRunnable2.setThread(thread1);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static class MyRunnable implements Runnable{
        private Thread thread;
        private final Object monitor;

        public MyRunnable(Object monitor) {
            this.monitor = monitor;
        }

        public void setThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            synchronized (monitor){
                for (int i=0;i<3;i++){
                    try {
                        log.info("execution");
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
                        log.info("begin interrupt");
                        thread.interrupt();
                        log.info("begin wait");
                        monitor.wait();
                    }catch (InterruptedException e){
                        log.error("interrupted");
                    }
                }
            }
        }
    }
}
