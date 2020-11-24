package com.example.demo.algorithm.observe.impl;

import com.example.demo.algorithm.observe.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/24 10:52
 */
@Component
public class SubjectDisseminator implements Subject {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void notifys() {
        Object data = new Object();
        SubjectEvent subjectEvent = new SubjectEvent(data);
        applicationContext.publishEvent(subjectEvent);
    }
}
