package com.example.demo.algorithm.finitestatemachine;

/**
 * @author: anjd
 * @description: change status to anothor
 * @date: 2020/11/20 11:01
 */
public interface Transition {
    /**
     * @author: anjd
     * @description: do change
     * @date: 2020/11/20 11:04
     * @return
     */
    void postShift();
}
