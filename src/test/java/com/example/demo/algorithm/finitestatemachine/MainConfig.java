package com.example.demo.algorithm.finitestatemachine;

import com.example.demo.algorithm.finitestatemachine.soilder.SoliderStatusContext;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Enemy;
import com.example.demo.algorithm.finitestatemachine.soilder.models.Solider;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
@Slf4j
public class MainConfig {
    /* @description: Finite State Machine Algorithm（有限状态机模式）
     * @author: 18810
     * @create: 2020/11/20
     * @param:
     * @return null
     **/
    @Bean
    @Primary
    public Solider theSoliderTest(){
        Solider solider = new Solider(0, 50, 2);
        return solider;
    }

    @Bean
    @Primary
    public SoliderStatusContext soliderStatusContextTest(Solider solider){
        SoliderStatusContext soliderStatusContext = new SoliderStatusContext(solider);
        return soliderStatusContext;
    }
}
