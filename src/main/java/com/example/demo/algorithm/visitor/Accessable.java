package com.example.demo.algorithm.visitor;

public interface Accessable<T extends Operable> {
    void access(T operation);
}
