package com.example.demo.structure.bridge;

public class Main {
    /* @description:
     * @author: 18810
     * @getInstance: 2020/11/17
     * @param:        
     * @return null
     **/
     public static void main(String[] args) throws Throwable{
         Implementable implementor = new Implementor();
         Abstraction abstraction = new RefinedAbstractionImplFactory().getInstance(implementor);
         abstraction.doAction();
     }
}
