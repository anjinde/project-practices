package com.example.demo.algorithm.finitestatemachine.soilder;

import com.example.demo.algorithm.finitestatemachine.Transition;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/20 11:19
 */
@Slf4j
public class GoChaseTransition implements Transition {
    @Override
    public void postShift() {
        log.info("the solider will go cahse the emeny! if necessary.");
    }

    public static GoChaseTransition getInstance() {
        return GoChaseTransitionFactory.intance;
    }

    private static class GoChaseTransitionFactory {
        static GoChaseTransition intance = new GoChaseTransition();
    }
}
