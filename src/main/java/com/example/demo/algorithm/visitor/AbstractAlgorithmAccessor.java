package com.example.demo.algorithm.visitor;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * @description: 将稳定的数据结构，封装到 Accessor
 *  display on the algorithm which given
 * @author: xxx
 * @date: 2020/11/23 10:55
 */
public abstract class AbstractAlgorithmAccessor<T extends Accessable> {
    private List<T> accessables = Lists.newArrayList();

    /**
     * @author: anjd
     * @description: 添加 源 数据结构
     * @date: 2020/11/23 11:16
     * @param accessable 源数据结构
     * @return
     */
    public void attach(T accessable) {
        this.accessables.add(accessable);
    }

    public void detach(T accessable){
        this.accessables.remove(accessable);
    }

    public void display(Operable operation) {
        Objects.requireNonNull(operation);
        accessables.forEach(accessable -> accessable.access(operation));
    }

}
