package com.example.demo.algorithm.states;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/23 17:24
 */
public interface Status {
    //执行 状态 对应的逻辑分支
    void process(StatusProcesser statusProcesser);
}
