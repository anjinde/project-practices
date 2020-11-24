package com.example.demo.structure.bridge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * defined main abstraction relationship & methods
 */
@Slf4j
@AllArgsConstructor
public abstract class Abstraction {
    protected abstract void init();
    @Getter
    @Setter
    protected Implementable implementor;
    protected abstract void doAction();
}
