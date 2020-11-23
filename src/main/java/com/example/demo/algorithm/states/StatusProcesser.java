package com.example.demo.algorithm.states;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * 面向对象设计其实就是希望做到代码的责任分解，方法过程如果过长将会变得难以扩展和修改。
 * 这也是状态模式的目的。状态模式是行为设计模式的一种。
 * 当然这里还有由状态模式演变而来的有限状态机。
 *
 * 1. 意图：
 * 将代码中大量与对象有关的的条件语句拆分，方便扩展和修改。
 *
 * @author: xxx
 * @date: 2020/11/23 17:23
 */
public class StatusProcesser {
    @Getter
    @Setter
    private Status currentStatus;

    //包含分支判断的 依赖数据
    @Getter
    @Setter
    private Feature feature;

    public StatusProcesser(Status toStatus) {
        this.currentStatus = toStatus;
    }

    /*
       执行 当前状态对应的逻辑分支
     */
    public void process(){
        this.currentStatus.process(this);
    }
}
