package com.fy.java.threads;

public class SimpleThreads {
    // display a message, preceded by the name of the current thread
    static void threadMessage(String message){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable{

        @Override
        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            try {
                for(int i=0;i< importantInfo.length;i++){
                    Thread.sleep(4000);
                    threadMessage(importantInfo[i]);
                }
            }catch (InterruptedException e){
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        long patience = 1000 * 60 * 60;
        if(args.length > 0){
            try {
                patience = Long.parseLong(args[0]) * 1000;
            }catch (NumberFormatException e){
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop Thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        while (t.isAlive()){
            threadMessage("still waiting...");

            t.join(1000);

            if(((System.currentTimeMillis() - startTime) > patience) && t.isAlive()){
                threadMessage("tired of waiting");
                t.interrupt();
                //
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
