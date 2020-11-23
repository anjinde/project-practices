package com.example.demo.algorithm.visitor;

@FunctionalInterface
public interface Operable<T extends Accessable> {
    void operate(T accessable);
}
