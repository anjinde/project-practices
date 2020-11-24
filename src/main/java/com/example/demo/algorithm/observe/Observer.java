package com.example.demo.algorithm.observe;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/24 10:45
 */
public interface Observer<V> {
    void receive(V value);
}
