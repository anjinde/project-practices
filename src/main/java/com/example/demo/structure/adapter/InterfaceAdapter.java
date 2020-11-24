package com.example.demo.structure.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/24 16:43
 */
@Slf4j
public class InterfaceAdapter implements InterfaceStandard,InterfaceA{
    private InterfaceStandard existStandardClass;

    @Override
    public void method() {
        log.info("adapte this methods for exist standard");
    }

    @Override
    public void standardMethod() {
        existStandardClass.standardMethod();
    }
}
