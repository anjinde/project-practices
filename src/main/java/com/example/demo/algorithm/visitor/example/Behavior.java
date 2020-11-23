package com.example.demo.algorithm.visitor.example;

import com.example.demo.algorithm.visitor.example.impl.Man;
import com.example.demo.algorithm.visitor.example.impl.Women;

/**
 * @description: 行为算法
 * @author: xxx
 * @date: 2020/11/23 13:50
 */
public interface Behavior {
    /*
     为 不同类型的目标数据结构 声明操作入口
     */
    void operate(Man man);
    void operate(Women women);
}
