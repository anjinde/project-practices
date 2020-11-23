package com.example.demo.algorithm.finitestatemachine;

/**
 * @author: anjd
 * @description: status context 状态上下文
 * @date: 2020/11/20 10:35
 */
public interface StatusContext {
    /**
     * @author: anjd
     * @description: transition shift 初态to 次态another status
     * @date: 2020/11/20 13:46
     */
    Status shift(Transition transition);

    /**
     * @author: anjd
     * @description: listen status context event from outside
     * @date: 2020/11/20 13:54
     */
    <T> void onListen(StatusContextEvent<T> event);
}
