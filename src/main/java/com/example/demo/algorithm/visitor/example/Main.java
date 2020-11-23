package com.example.demo.algorithm.visitor.example;

import com.example.demo.algorithm.visitor.example.impl.Man;
import com.example.demo.algorithm.visitor.example.impl.Success;
import com.example.demo.algorithm.visitor.example.impl.Women;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/23 13:57
 */
public class Main {
    
    /* @description:  需要扩展修改 behavior,accssable 只修改access接口代码，对本身数据结构的代码不做修改
     accssable的方法签名不变， 传入this，这种做法自动适配自身类型，所以相当于 只修改behavior即可；
     如果有其他操作类型声明， 实现多个种类的accessable即可， 或者直接维护修改一个accessable的定义
     * @author: 18810
     * @create: 2020/11/23
     * @param:
     * @return null
     **/
     public static void main(String[] args) throws Throwable{
         HumanBehaivorAccessor humanBehaivorAccessor = new HumanBehaivorAccessor();
         Man zs = new Man();
         Women xiaol = new Women();
         humanBehaivorAccessor.attach(zs);
         humanBehaivorAccessor.attach(xiaol);

         humanBehaivorAccessor.display(new Success());
     }
}
