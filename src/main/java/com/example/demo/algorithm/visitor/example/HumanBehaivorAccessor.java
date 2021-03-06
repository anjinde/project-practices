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
 *
 * 依赖倒置原则的定义
 *      依赖倒置原则（Dependence Inversion Principle，简称DIP）这个名字看着有点别扭，“依赖”还“倒置”，这到底是什么意思？依赖倒置原则的原始定义是：High level modules should not depend upon low level modules. Both should depend upon abstractions. Abstractions should not depend upon details. Details should depend upon abstractions。翻译过来，包含三层含义：
 *
 * 高层模块不应该依赖低层模块，两者都应该依赖其抽象；
 * 抽象不应该依赖细节；
 * 细节应该依赖抽象。
 *      高层模块和低层模块容易理解，每一个逻辑的实现都是由原子逻辑组成的，不可分割的原子逻辑就是低层模块，原子逻辑的再组装就是高层模块。那什么是抽象，什么又是细节呢？在Java语言中，抽象就是指接口或抽象类，两者都是不能直接被实例化的；细节就是实现类，实现接口或继承抽象类而产生的类就是细节，其特点就是可以直接被实例化，也就是可以加上一个关键字new产生一个对象。依赖倒置原则在Java语言中的表现就是：
 *
 * 模块间的依赖是通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或抽象类产生的；
 * 接口或抽象类不依赖于实现类；
 * 实现类依赖接口或抽象类。
 *
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
