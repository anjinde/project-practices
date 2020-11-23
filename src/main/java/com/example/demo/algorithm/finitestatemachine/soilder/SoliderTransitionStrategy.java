package com.example.demo.algorithm.finitestatemachine.soilder;

import com.example.demo.algorithm.finitestatemachine.Transition;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Enemy;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Solider;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/20 14:20
 */
public class SoliderTransitionStrategy {
    public Transition determine(Solider solider, List<Enemy> enemys){
        //判断 是否有在
        List<Enemy> enemyAroundFinds =
                CollectionUtils.isEmpty(enemys) ? Collections.emptyList() : enemys.stream().filter(enemy -> distance(solider.getPostion(), enemy.getPostion()) <= solider.getArroudIn()).collect(Collectors.toList());

        List<Enemy> enemyCanAttack =
                enemyAroundFinds.stream().filter(enemy -> distance(solider.getPostion(), enemy.getPostion())  <= solider.getAttackIn()).collect(Collectors.toList());

            return enemyCanAttack.size() > 0? GoAttackTransition.getInstance():
                    enemyAroundFinds.size() > 0? GoChaseTransition.getInstance() : GoStandTransition.getInstance();
    }

    private long distance(long from, long to) {
        return Math.abs(to) - Math.abs(from);
    }
    private Enemy leastEnemy(List<Enemy> enemies) {
        return enemies.stream()
                .reduce((least, enemy) -> enemy.getPostion() < least.getPostion()? enemy : least).get();
    }
}
