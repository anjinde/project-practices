package com.example.demo.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Implementor implements Implementable{
    @Override
    public void suit() {
        log.info("Implementor suit...");
    }
}
