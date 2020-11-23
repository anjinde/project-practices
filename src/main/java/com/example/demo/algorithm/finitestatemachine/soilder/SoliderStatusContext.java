package com.example.demo.algorithm.finitestatemachine.soilder;

import com.example.demo.algorithm.finitestatemachine.AbstractStatusContext;
import com.example.demo.algorithm.finitestatemachine.Status;
import com.example.demo.algorithm.finitestatemachine.StatusContextEvent;
import com.example.demo.algorithm.finitestatemachine.Transition;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Enemy;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Solider;
import com.example.demo.common.utils.Json;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

import java.util.List;

import static com.example.demo.algorithm.finitestatemachine.soilder.SoliderStatus.*;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/20 13:57
 */
@Slf4j
public class SoliderStatusContext extends AbstractStatusContext implements ApplicationListener<SoliderTransitionEvent>{

    public SoliderStatusContext(Solider belongs){
        this.maintainSolider = belongs;
        this.init();
    }

    //持有方式？
    private Solider maintainSolider;

    @Override
    public void onApplicationEvent(SoliderTransitionEvent event) {
        onListen(event);
    }

    @Override
    public void onListen(StatusContextEvent event) {
        if(event instanceof SoliderTransitionEvent){
            List<Enemy> enemies = (List<Enemy>)event.getData();
            SoliderTransitionStrategy transitionStrategy = new SoliderTransitionStrategy();
            //todo 方式
            Transition transition = transitionStrategy.determine(maintainSolider, enemies);
            shift(transition);
            return;
        }

        log.info("其他事件... {}", Json.toString(event));
    }

    @Override
    protected void init() {
        this.shiftTable = Maps.newHashMap();
        this.shiftTable.put(GoChaseTransition.getInstance(), Chase);
        this.shiftTable.put(GoAttackTransition.getInstance(), Attack);
        this.shiftTable.put(GoStandTransition.getInstance(), Stand);
    }

    @Override
    protected void doBeforeShift(Status afterwards) {
        log.info("the soilder will on: {}", afterwards);
    }

    @Override
    protected void doAfterShift() {
        log.info("the soilder {}", this.currentStatus);
    }
}
