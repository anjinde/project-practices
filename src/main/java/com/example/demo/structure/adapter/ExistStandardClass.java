package com.example.demo.structure.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/24 16:42
 */
@Slf4j
public class ExistStandardClass implements InterfaceStandard{
    @Override
    public void standardMethod() {
        log.info("ExistStandardClass standardMethod");
    }
}
