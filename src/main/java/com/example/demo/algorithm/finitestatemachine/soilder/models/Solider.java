package com.example.demo.algorithm.finitestatemachine.soilder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/11/20 14:00
 */
@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class Solider {
    private long postion;
    private long arroudIn = 50;
    private long attackIn = 2;
}
