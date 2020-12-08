package com.example.demo.reactiveprograme;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/12/8 18:14
 */
@Log4j2
@SpringBootApplication
public class WebFluxApplication {
    public static void main(String[] args) { SpringApplication.run(WebFluxApplication.class, args); }

    @RestController
    class EmployeeController{

        /*
            连接在 flux 基础上 进行 server sent
         */
        @GetMapping(value = "sse",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
        public Flux<String> sse1(){
            return Flux.interval(Duration.ofMillis(1000)).map(val ->val.toString());
        }
    }
}
