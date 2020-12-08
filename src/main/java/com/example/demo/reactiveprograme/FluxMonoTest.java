package com.example.demo.reactiveprograme;

import com.example.demo.common.utils.Json;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple3;
import reactor.util.function.Tuple4;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @description: TODO
 * @author: xxx
 * @date: 2020/12/2 11:17
 */
@Slf4j
public class FluxMonoTest {

    /* @description:
     * @author: 18810
     * @create: 2020/12/2
     * @param:
     * @return null
     **/
     public static void main(String[] args) throws Throwable{
         /*Flux<Long> interval =  Flux.interval(Duration.ofMillis(1000));
         interval.subscribe(timestamp -> {
            log.info("times:{}", timestamp);
         });

         Flux.fromStream(Stream.of("n1","n2","n3"))
                 .subscribe(str -> log.info("n* says:{}", str));

         Mono<String> x = Mono.fromSupplier(FluxMonoTest::queryLongs)
                 .flatMap(v -> Mono.just(v+"随机数字、"));

         x.subscribe(System.out::println);*/

         Flux<Long> a = Flux.interval(Duration.ofMillis(1500))
                 .doFirst(()-> log.info("run"))
                 .doOnError(e -> log.error("i thrown the error?", e))
                 .doFinally(x2 -> Json.toString(x2))
                 .doOnComplete(()-> log.info("work out"));

         MutableInt xx = new MutableInt(0);
       /*  a.subscribe(clock -> {
             log.info("clock for {}", clock);
             if(xx.incrementAndGet() > 1000)
                 throw new RuntimeException("now throw except");
         }, error -> log.error("its error,{}",error.getMessage()),
                 () -> {
                    log.info("its finish");
                 }, subscription -> {
                    subscription.request(10);
                    log.info("subscription");
                 });*/

         Flux.just(Lists.newArrayList(1,2,3,4,5,6,7,8).toArray())
                 .subscribe(v-> log.info("handle v {}", v), err -> log.error("",err), ()-> log.info("finish"), subscription -> subscription.request(Long.MAX_VALUE));


         //base data
         Flux<Temp> tempFlux = Flux.just(queryTemps().toArray(new Temp[]{}));


         //1
         tempFlux.map(temp ->{
             if(temp.getPropa()>3)
                 throw new IllegalArgumentException("test throw it" + Json.toJson(temp));
             return temp;
         }).onErrorResume(e -> {
             log.info("thrown:{}", e.getMessage());
             return Flux.just(otherTemps().toArray(new Temp[]{}));
         }).subscribe(temp -> log.info("this f:{}", temp));

         /*
            上面只是定义数据处理流 stream
            在订阅执行时定义work fun处理流， 转化，异常处理...等
            随着订阅的执行，work fun也才会
          */
         tempFlux.subscribe(temp -> {
             log.info("consume temp:{}", Json.toJson(temp));
         });


         //2
         /*
         17:15:06.754 [main] INFO com.example.demo.reactiveprograme.FluxMonoTest - group of :&0&1
        17:15:06.754 [main] INFO com.example.demo.reactiveprograme.FluxMonoTest - group of :&2&3
        17:15:06.754 [main] INFO com.example.demo.reactiveprograme.FluxMonoTest - group of :&4&5
        17:15:06.754 [main] INFO com.example.demo.reactiveprograme.FluxMonoTest - group of :&6
          */
        Flux<Flux<Temp>> fluxFlux =  tempFlux.window(2);
        Flux<String> results = fluxFlux.flatMap(tempFlux1 -> tempFlux1.reduce("", (result, tempFlux2)-> result+=("&"+tempFlux2.getPropa()) ));

        results.subscribe(str -> log.info("group of :"+ str));

         tempFlux.window(3).flatMap(tempFlux1 -> tempFlux1.reduce("", (result, tempFlux2)-> result+=("&"+tempFlux2.getPropa()) ))
            .subscribe(str -> log.info("3group of :"+ str));

        log.info("\n");
         fluxFlux.flatMap(tempFlux1 ->  tempFlux1.map(temp -> Json.toJson(temp)) )
                 .delayElements(Duration.ofMillis(200))
                 .subscribe(s -> log.info(s));




         Flux<String> stringFlux1 = Flux.just("a","b","c","d","e");
         Flux<String> stringFlux2 = Flux.just("f","g","h","i");
         Flux<String> stringFlux3 = Flux.just("1","2","3","4");
         Flux<String> stringFlux4 = Flux.just("1","2","3","4");
        //方法一zipWith
         stringFlux1.zipWith(stringFlux2).subscribe(x -> log.info("->{}",x));
         System.out.println();

         /*
            17:55:52.403 [main] INFO com.example.demo.reactiveprograme.FluxMonoTest - ->[a,f,1,1]
            17:55:52.403 [main] INFO com.example.demo.reactiveprograme.FluxMonoTest - ->[b,g,2,2]
            17:55:52.403 [main] INFO com.example.demo.reactiveprograme.FluxMonoTest - ->[c,h,3,3]
            17:55:52.403 [main] INFO com.example.demo.reactiveprograme.FluxMonoTest - ->[d,i,4,4]
          */
         Flux<Tuple4<String,String,String,String>> tuple2Flux = Flux.zip(stringFlux1,stringFlux2,stringFlux3, stringFlux4);
         tuple2Flux.subscribe(x -> log.info("->{}",x));

         Thread.sleep(Long.MAX_VALUE);
         log.info("main thread over");
     }

     private static List<Temp> queryTemps(){
         return Lists.newArrayList(
                 new Temp().setPropa(0).setPropb("p0"),
                 new Temp().setPropa(1).setPropb("p1"),
                 new Temp().setPropa(2).setPropb("p2"),
                 new Temp().setPropa(3).setPropb("p3"),
                 new Temp().setPropa(4).setPropb("p4"),
                 new Temp().setPropa(5).setPropb("p5"),
                 new Temp().setPropa(6).setPropb("p6")
         );
     }
    private static List<Temp> otherTemps(){
        return Lists.newArrayList(
                new Temp().setPropa(5).setPropb("np5"),
                new Temp().setPropa(6).setPropb("np6")
        );
    }


     private static Long queryLongs(){
         return new Random().nextLong();
     }

     @Data
     @Accessors(chain = true)
     static class Temp {
         private int propa;
         private String propb;
     }



    @Test
    public void pressure() throws InterruptedException {
        Flux<Long> longFlux = Flux.interval(Duration.ofMillis(1000));
        longFlux.subscribe(new Subscriber<Long>() {
            Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            private void handlerPerform(Long v){
                LogFactory.getLog(this.getClass()).info("handlerPerform : " + v);
            }

            @Override
            public void onNext(Long aLong) {
                handlerPerform(aLong);
                /*
                 back press a request of next stream element
                 */
                if(aLong.equals(10L))
                try {
                    LogFactory.getLog(this.getClass()).info("now sleep 5s");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscription.request(1);
                System.out.println("val:"+aLong);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });

        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void testParallel(){
        Flux.range(1,10)
                /*
                 核心部分1：
                    通过 parallel设置并行参数
                    默认且最高值为 cpu核数
                 */
                .parallel()
                /*
                   核心部分2:
                       通过声明 调度器 进行策略调度
                        elastic 为弹性调度， 会在parallel基础上，自行决策线程资源的分配
                        parallel 映射于parallel声明的 声明线程调度器
                        immediate 立即在主线程执行 也就没有入队调度器单独调度了
                 */
                .runOn(Schedulers.parallel())
                .subscribe(x ->log.info("->{}",x));
    }
}
