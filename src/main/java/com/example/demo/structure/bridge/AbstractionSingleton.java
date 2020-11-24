package com.example.demo.structure.bridge;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 事实上，其bridging 里不可能有 单利
 * 这里只是顺手写一下，熟练一下
 */
@Slf4j
public class AbstractionSingleton {

    @Slf4j
    private static class AbstractioinFactory{
        private static Abstraction instance = new Abstraction(null) {
            @Override
            protected void init() {
                log.info("Abstraction Singleton run init...");
            }

            @Override
            public void doAction() {
                Objects.requireNonNull(implementor, "Implementable must given");
                implementor.suit();
                log.info("Implementable suited just, then init");
                this.init();
                log.info("now AbstractionSingleton core runing here with impltor:{}", implementor);
            }
        };
    }

    public static Abstraction getInstance(){
        return AbstractioinFactory.instance;
    }

}
