package com.fy.java;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class Producer implements Runnable{

    private DataExchanger dataExchanger;

    @Override
    public void run() {
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };
        for(String p : packets){
            dataExchanger.send(p);

            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                log.error("thread interrupted", e);
            }
        }
        log.info("producer quit");
    }
}
