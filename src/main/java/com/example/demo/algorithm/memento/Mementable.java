package com.example.demo.algorithm.memento;

public interface Mementable<T> {
    Memento<T> createMemento();
    void restoreMemento(Memento<T> memnto);
}
