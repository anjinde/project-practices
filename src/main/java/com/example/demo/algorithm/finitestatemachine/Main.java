package com.example.demo.algorithm.finitestatemachine;

import com.example.demo.algorithm.finitestatemachine.soilder.SoliderStatusContext;
import com.example.demo.algorithm.finitestatemachine.soilder.SoliderTransitionEvent;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Enemy;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Solider;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author: anjd
 * @description:
 * 有限状态机 的数学模型
 * 包含 现态（Status） 转变(Transition) 表现行为(Action) 次态（Status）
 * 这里案例我就没写Action部分， 即 当前状态 对应的feature & performance
 * @date: 2020/11/24 17:14
 * @param null
 * @return
 */
@Configuration
@Slf4j
public class Main {
    /* @description: Finite State Machine Algorithm（有限状态机模式）
     * @author: 18810
     * @create: 2020/11/20
     * @param:
     * @return null
     **/
    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public Solider theSolider(){
        Solider solider = new Solider(1000, 50, 2);
        return solider;
    }

    public List<Enemy> enemys(){
        return Lists.newArrayList(
                new Enemy(1500),
                new Enemy(1500),
                new Enemy(1500),
                new Enemy(1500) );
    }

    @Bean
    public SoliderStatusContext soliderStatusContext(Solider solider){
        SoliderStatusContext soliderStatusContext = new SoliderStatusContext(solider);
        return soliderStatusContext;
    }
}
