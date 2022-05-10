package com.fy.java;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class Consumer implements Runnable{
    private DataExchanger dataExchanger;
    @Override
    public void run() {
        for(String recieved = dataExchanger.receive(); !"End".equals(recieved) ; recieved = dataExchanger.receive()){
            log.info("recieved message : {}", recieved);

            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                log.error("thread interrupted", e);
            }
        }
        log.info("consumer quit");
    }
}
