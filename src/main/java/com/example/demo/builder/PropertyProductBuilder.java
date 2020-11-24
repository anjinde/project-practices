package com.example.demo.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * 也可以 作为属性收集器
 * 结合策略 去构建
 * @author: xxx
 * @date: 2020/11/24 16:56
 */
@Slf4j
public class PropertyProductBuilder implements ProductBuilder{
    private ProductProperty property;

    @Override
    public ProductBuilder buildPartA() {
        //这里简化一下，代表不同的属性
        property = new ProductProperty(){
            private int somedataForPartA;
        };
        return null;
    }

    @Override
    public ProductBuilder buildPartB() {
        //这里简化一下，代表不同的属性
        property = new ProductProperty(){
            private int somedataForPartB;
        };
        return null;
    }

    @Override
    public ProductBuilder buildPartC() {
        //这里简化一下，代表不同的属性
        property = new ProductProperty(){
            private int somedataForPartC;
        };
        return null;
    }

    @Override
    public Product build() {
        return new Product(property);
    }
}
