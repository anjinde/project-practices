package com.example.demo.algorithm.observe.impl;

import com.example.demo.algorithm.observe.Observer;
import com.example.demo.common.utils.Json;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/24 10:50
 */
@Slf4j
public class SubjectObserver implements Observer {
    @Override
    public void receive(Object value) {
       log.info("观察到subject 通知，value:{}", Json.toString(value));
    }
}
