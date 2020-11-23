package com.example.demo.algorithm.finitestatemachine.soilder;

import com.example.demo.algorithm.finitestatemachine.Transition;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/20 11:20
 */
@Slf4j
public class GoAttackTransition implements Transition {

    private GoAttackTransition(){}
    @Override
    public void postShift() {
        log.info("solider now has to attack on his gun! no necessay, it grim, no...");
    }

    public static GoAttackTransition getInstance() {
        return GoAttackTransitionFactory.intance;
    }

    private static class GoAttackTransitionFactory {
        static GoAttackTransition intance = new GoAttackTransition();
    }

}
