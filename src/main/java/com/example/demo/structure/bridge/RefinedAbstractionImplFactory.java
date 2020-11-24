package com.example.demo.structure.bridge;

public class RefinedAbstractionImplFactory extends AbstractFactory{

    @Override
    public Abstraction getInstance(Implementable implementable) {
        return new RefinedAbstractionImpl(implementable);
    }
}
