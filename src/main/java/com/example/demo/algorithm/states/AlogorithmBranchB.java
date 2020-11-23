package com.example.demo.algorithm.states;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/23 17:34
 */
@Slf4j
public class AlogorithmBranchB implements Status{

    private Predicate<Feature> onCondition = feature -> feature.getFeatureData1() > 1000 && !feature.isFeatureData2();

    private AlogorithmBranchB(){}

    @Override
    public void process(StatusProcesser statusProcesser) {
        if(onCondition.test(statusProcesser.getFeature())){
            log.info("branch b process");
        } else {
            log.info("main alogorithm process on branch end");
        }
    }

    public static AlogorithmBranchB getInstance() {
        return AlogorithmBranchBFactory.instance;
    }

    private static class AlogorithmBranchBFactory {
        static AlogorithmBranchB instance = new AlogorithmBranchB();
    }
}
