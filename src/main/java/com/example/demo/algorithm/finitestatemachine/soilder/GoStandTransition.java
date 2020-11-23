package com.example.demo.algorithm.finitestatemachine.soilder;

import com.example.demo.algorithm.finitestatemachine.Transition;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/20 11:16
 */
@Slf4j
public class GoStandTransition implements Transition {
    @Override
    public void postShift() {
        log.info("the solider will go stand if necessary");
    }

    public static GoStandTransition getInstance() {
        return GoStandTransitionFactory.intance;
    }

    private static class GoStandTransitionFactory {
        static GoStandTransition intance = new GoStandTransition();
    }
}
