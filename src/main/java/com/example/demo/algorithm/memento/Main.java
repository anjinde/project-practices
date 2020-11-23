package com.example.demo.algorithm.memento;

import com.example.demo.common.utils.Json;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
public class Main {

    /* @description:
     * @author: 18810
     * @create: 2020/11/19
     * @param:
     * @return null
     **/
     public static void main(String[] args) throws Throwable{
         Example a = new Example();
         a.setStr("222");
         ThreadLocalStorage<Example> storage = new ThreadLocalStorage<>();
         storage.setMemnto(a.createMemento());
         a.setStr("666");
         a.setTimeStamp(Instant.now());
         log.info("now change example to:{}", Json.toString(a));
         log.info("restore a from memento");
         a.restoreMemento(storage.getMemnto().get());
     }
}
