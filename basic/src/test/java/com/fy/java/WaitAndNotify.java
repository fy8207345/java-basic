package com.fy.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WaitAndNotify {

    @Test
    public void name() throws InterruptedException {
        DataExchanger dataExchanger = new DataExchanger();

        Thread producer = new Thread(new Producer(dataExchanger), "producer");
        Thread consumer = new Thread(new Consumer(dataExchanger), "consumer");


        producer.start();
        consumer.start();

        System.out.println("started");

        producer.join();
        System.out.println("producer joined");
        consumer.join();
        System.out.println("consumer joined");
    }
}
