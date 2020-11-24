package com.example.demo.structure.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RefinedAbstractionImpl extends Abstraction{

    public RefinedAbstractionImpl(Implementable implementor) {
        super(implementor);
    }

    @Override
    protected void init() {
        log.info("RefinedAbstractionImpl init...");
    }

    @Override
    public void doAction() {
        implementor.suit();
        log.info("Implementable suited just, then init");
        this.init();
        log.info("now RefinedAbstractionImpl core runing here with impltor:{}", implementor);
    }
}
