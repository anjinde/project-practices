package com.example.demo.algorithm.finitestatemachine;

import com.example.demo.DemoApplication;
import com.example.demo.algorithm.finitestatemachine.soilder.SoliderTransitionEvent;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Enemy;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Solider;
import com.example.demo.common.utils.Json;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/20 17:15
 */
@Slf4j
@SpringBootTest(classes = DemoApplication.class)
public class MainTest {

    @Autowired
    Solider solider;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test(){
        List<Enemy> enemys;
        for(;;){
            log.info("\n\ntesting ...");
            enemys = enemys();
            applicationContext.publishEvent(new SoliderTransitionEvent(enemys));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Enemy> enemys(){
        int range=100;
        int num = (int) (Math.random()*(range));
        num *= Math.random() < 0.5? -1: 1;
        log.info("solider说： enemy 在50米内 追击， 2米内 攻击， 50米开外看不到则继续站岗");
        Enemy enemy = new Enemy( num);
        log.info("下一个enemy:{}", Json.toJson(enemy));
        return Lists.newArrayList(enemy);
    }
}
