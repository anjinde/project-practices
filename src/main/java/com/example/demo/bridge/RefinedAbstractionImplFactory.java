package com.example.demo.bridge;

public class RefinedAbstractionImplFactory extends AbstractFactory{

    @Override
    public Abstraction getInstance(Implementable implementable) {
        return new RefinedAbstractionImpl(implementable);
    }
}
