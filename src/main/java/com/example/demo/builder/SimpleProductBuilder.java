package com.example.demo.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/24 13:49
 */
@Slf4j
public class SimpleProductBuilder implements ProductBuilder{
    private Product instance;

    public SimpleProductBuilder() {
        instance = new Product();
    }

    @Override
    public ProductBuilder buildPartA() {
        log.info("build part a with factory if provided");
        return this;
    }

    @Override
    public ProductBuilder buildPartB() {
        log.info("build part b with factory if provided");
        return this;
    }

    @Override
    public ProductBuilder buildPartC() {
        log.info("build part c with factory if provided");
        return this;
    }

    @Override
    public Product build() {
        log.info("build finishd here, return the instance");
        return instance;
    }
}
