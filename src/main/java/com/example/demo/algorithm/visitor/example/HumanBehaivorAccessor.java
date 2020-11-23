package com.example.demo.algorithm.visitor.example;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @description:
 * 将数据结构 与 数据操作分离
 * 核心： 在被访问的类里，加一个对外提供接受访问者的接口（Accessable）
 * 将自身引用传入访问者；
 *
 * 缺点：
 * 违反最小知识原则，依赖倒置（依赖了实现类型，而不是对象）
 * operateable 接口中 对各种具体类型的接口签名定义
 * @author: xxx
 * @date: 2020/11/23 13:52
 */
public class HumanBehaivorAccessor {
    private List<Person> persons = Lists.newLinkedList();

    public void attach(Person person) {
        detach(person);
        this.persons.add(person);
    }

    public void detach(Person person) {
        this.persons.remove(person);
    }

    public void display(Behavior behavior){
        persons.forEach(person -> person.access(behavior));
    }
}
