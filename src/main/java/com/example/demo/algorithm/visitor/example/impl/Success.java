package com.example.demo.algorithm.visitor.example.impl;

import com.example.demo.algorithm.visitor.example.Behavior;
import com.example.demo.common.utils.Json;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 定义成功 这一行为
 * @author: xxx
 * @date: 2020/11/23 14:00
 */
@Slf4j
public class Success implements Behavior {
    @Override
    public void operate(Man man) {
        log.info("man success， take a bire parrty, {}", Json.toString(man));
    }

    @Override
    public void operate(Women women) {
        log.info("women success, take a sweet lauch, {}", Json.toString(women));
    }
}
