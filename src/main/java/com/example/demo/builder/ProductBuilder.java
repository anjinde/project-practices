package com.example.demo.builder;

/**
 * @author: anjd
 * @description:
 * 建造者模式是建造者模式的一种。
 * 一个人活到70岁以上，都会经历这样的几个阶段：婴儿，少年，青年，中年，老年，并且每个人在各个阶段肯定是不一样的，我觉得可以说世界上不存在两个人在人生的这个5个阶段的生活完全一样，但是活到70岁以上的人，都经历了这几个阶段。
 * 建造者模式：是将一个复杂的对象的构建与它的表示分离，使得同样的构造过程可以创建不同的表示。建造者模式和工厂模式非常相似啊，建造者模式注重零部件的组装过程，而工厂方法模式更注重零件的创建过程。两者也有结合使用，比如众神造人，女娲利用建造者模式负责吧灵魂，耳目，手臂等组合成一个完整的人，而皇帝，桑林等人各自利用工厂模式创造出灵魂，耳目，手臂等。女娲不必考虑灵魂，耳目，手臂是什么样子的，怎么创造出来的，这就成为了一个由建造者模式和工厂方法模式组合而成的系统。
 * 使用建造者模式的场合和好处。
 * 使用建造者模式的好处：
 * 1.使用建造者模式可以使客户端不必知道产品内部组成的细节。
 * 2.具体的建造者之间是相互独立的，对系统的扩展非常有利。
 * 3.由于具体的建造者是独立的，因此可以对建造过程逐步细化，而不对其他的模块产生任何影响。
 * 使用建造者模式的场合：
 * 1.创建一些复杂的对象时，这些对象的内部组成构件间的建造顺序是稳定的，但是对象的内部组成构件面临着复杂的变化。
 * 2.要创建的复杂对象的算法，独立于该对象的组成部分，也独立于组成部分的装配方法时。
 * @date: 2020/11/24 13:53
 */
public interface ProductBuilder {
    ProductBuilder buildPartA();
    ProductBuilder buildPartB();
    ProductBuilder buildPartC();
    Product build();
}