package com.example.demo.algorithm.visitor.example.impl;

import com.example.demo.algorithm.visitor.example.Behavior;
import com.example.demo.algorithm.visitor.example.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/23 13:58
 */
@Slf4j
public class Women implements Person {
    @Override
    public void access(Behavior behavior) {
        //person实现类 去决定 与自己匹配的行为 operate接口入口的调用
        behavior.operate(this);
    }
}
