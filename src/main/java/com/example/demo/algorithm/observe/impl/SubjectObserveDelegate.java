package com.example.demo.algorithm.observe.impl;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.ApplicationListener;

import java.util.List;
import java.util.Objects;

/**
 * @description:  observer事件性委托(和前端dom那个  元素事件委托 不是一回事)
 * 代替 observer 对接subjectEvent， 适配observer 接口
 * @author: xxx
 * @date: 2020/11/24 10:44
 */
public class SubjectObserveDelegate implements ApplicationListener<SubjectEvent> {
    //地址分配了， 对象也创建了 原子步骤
    private volatile List<SubjectObserver> subjectObservers;

    @Override
    public void onApplicationEvent(SubjectEvent subjectEvent) {
        subjectObservers.forEach(subjectObserver -> subjectObserver.receive(subjectEvent.getSource()));
    }

    public synchronized void delegate(SubjectObserver subjectObserver) {

        Objects.requireNonNull(subjectObserver);
        if(CollectionUtils.isEmpty(subjectObservers))
            subjectObservers = Lists.newArrayList();
        subjectObservers.add(subjectObserver);
    }
}
