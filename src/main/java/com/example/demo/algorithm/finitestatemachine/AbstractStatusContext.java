package com.example.demo.algorithm.finitestatemachine;

import java.util.Map;
import java.util.Objects;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/20 15:22
 */
public abstract class AbstractStatusContext implements StatusContext {
    /**
     * @description: 当前状态 shift> 下一状态 的 transition转换映射表
     *   数据结构是： 当前状态 curStatus；
     *   因 转变动作transition 转换到 下一状态 Status afterwards
     * @date: 2020/11/20 15:25
     */
    protected Map<Transition, Status> shiftTable;
    protected volatile Status currentStatus;
    /**
     * @description: 初始化 当前状态的 转换映射表
     * @date: 2020/11/20 15:28
     */
    protected abstract void init();

    //context 上下文为 the solider
    @Override
    public synchronized Status shift(Transition transition) {
        Status afterwards = this.shiftTable.get(transition);
        if(Objects.isNull(afterwards))
            return currentStatus;//保持当前状态 stay

        this.doBeforeShift(afterwards);
        //shift status
        this.currentStatus = afterwards;
        this.doAfterShift();
        //transtion 执行状态转换完成
        transition.postShift();
        return this.currentStatus;
    }

    /**
     * @author: anjd
     * @description: 转换之前
     * @date: 2020/11/20 15:52
     */
    protected abstract void doBeforeShift(Status afterwards);
    /**
     * @author: anjd
     * @description: 转换完成后
     * @date: 2020/11/20 15:52
     */
    protected abstract void doAfterShift();
}
