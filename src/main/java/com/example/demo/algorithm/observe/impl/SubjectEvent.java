package com.example.demo.algorithm.observe.impl;

import org.springframework.context.ApplicationEvent;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/24 10:52
 */
public class SubjectEvent extends ApplicationEvent {
    public SubjectEvent(Object source) {
        super(source);
    }
}
