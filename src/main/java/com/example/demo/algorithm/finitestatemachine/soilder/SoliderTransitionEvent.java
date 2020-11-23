package com.example.demo.algorithm.finitestatemachine.soilder;

import com.example.demo.algorithm.finitestatemachine.StatusContextEvent;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Enemy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/20 13:59
 */
@Getter
@Setter
public class SoliderTransitionEvent extends ApplicationEvent implements StatusContextEvent<List<Enemy>> {

    private List<Enemy> enemys;

    public SoliderTransitionEvent(List<Enemy> enemys) {
        super(enemys);
        this.enemys = enemys;
    }

    @Override
    public List<Enemy> getData() {
        return enemys;
    }
}
