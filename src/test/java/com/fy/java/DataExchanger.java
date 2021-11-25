package com.fy.java;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataExchanger {
    private String packet;
    private volatile boolean transfer = true;

    public synchronized void send(String packet){
        while (!transfer){
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                log.error("thread interrupted", e);
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive(){
        while (transfer){
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                log.error("thread interrupted", e);
            }
        }
        transfer = true;
        notifyAll();
        return packet;
    }
}
