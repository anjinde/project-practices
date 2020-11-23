package com.example.demo.algorithm.states;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/23 17:34
 */
@Slf4j
public class AlogorithmBranchA implements Status{

    private Predicate<Feature> onCondition = feature -> feature.getFeatureData1() > 0 || feature.isFeatureData2();

    private AlogorithmBranchA(){}

    @Override
    public void process(StatusProcesser statusProcesser) {
        if(onCondition.test(statusProcesser.getFeature())) {
            log.info("branchA process");
        } else {
            //当前分支 需要定义切换到的 下一个分支 (==else if)
            statusProcesser.setCurrentStatus(AlogorithmBranchB.getInstance());
        }
    }

    public static AlogorithmBranchA getInstance() {
        return AlogorithmBranchAFactory.instance;
    }

    private static class AlogorithmBranchAFactory {
        static AlogorithmBranchA instance = new AlogorithmBranchA();
    }
}
