package com.example.demo.algorithm.memento;

import com.example.demo.common.utils.Json;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.Instant;

@Slf4j
@Getter
@Setter
public class Example implements Mementable<Example>, Serializable{
    private static final long serialVersionUID = 4424926281450261277L; //Mementable<Object> or Example？

    private String str;
    private Instant timeStamp;

    @Override
    public Memento<Example> createMemento() {
        return new ExampleMemento(this);
    }

    @Override
    public void restoreMemento(Memento<Example> memnto) {
        log.info("cur value:{}", Json.toString(this));
        log.info("restoreMemento from memnto:{}", Json.toString(memnto));
        BeanUtils.copyProperties(memnto.get(), this);
        log.info("restored complete:{} ", Json.toString(this));
    }


    class ExampleMemento implements Memento<Example>, Serializable {
        private static final long serialVersionUID = -5356554851176924595L;
        private Example example;
        ExampleMemento(Example example){
            this.example = new Example();
            BeanUtils.copyProperties(example, this.example);
        }

        @Override
        public Example get() {
            return example;
        }
    }
}
