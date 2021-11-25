package com.fy.java.threads;

import java.util.Random;

public class ProducerAndConsumer {
    //message sent from producer to consuer
    private String message;
    //true if consumer should wait for producer to send message
    //false if producer show wait for consumer to retrieve message
    private boolean empty = true;

    public synchronized String take(){
        //wait until message is available
        while (empty){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        //toggle status
        empty = true;
        //notify producer the status has changed
        notifyAll();
        return message;
    }

    public synchronized void put(String message){
        //wait until message has been taken
        while (!empty){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        empty = false;
        this.message = message;
        //notify consumer the status has changed
        notifyAll();
    }

    private static class Producer implements Runnable{

        private ProducerAndConsumer producerAndConsumer;

        public Producer(ProducerAndConsumer producerAndConsumer) {
            this.producerAndConsumer = producerAndConsumer;
        }

        @Override
        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            Random random = new Random();
            for (int i = 0;
                 i < importantInfo.length;
                 i++) {
                producerAndConsumer.put(importantInfo[i]);
                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {}
            }
            producerAndConsumer.put("DONE");
        }
    }

    private static class Consumer implements Runnable{
        private ProducerAndConsumer producerAndConsumer;

        public Consumer(ProducerAndConsumer producerAndConsumer) {
            this.producerAndConsumer = producerAndConsumer;
        }

        @Override
        public void run() {
            Random random = new Random();
            for (String message = producerAndConsumer.take();
                 ! message.equals("DONE");
                 message = producerAndConsumer.take()) {
                System.out.format("MESSAGE RECEIVED: %s%n", message);
                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {}
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        new Thread(new Producer(producerAndConsumer)).start();
        new Thread(new Consumer(producerAndConsumer)).start();
    }
}
