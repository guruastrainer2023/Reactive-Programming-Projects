package com.training;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Hello world!
 */
public class App2 {
    public static void main(String[] args) throws InterruptedException {
    	Mono.just("Hello")
        .publishOn(Schedulers.parallel())
        .map(data -> {
            System.out.println(Thread.currentThread().getName());
            return data;
        })
        .subscribe(System.out::println);
    	
    	Thread.sleep(5000);

    }
}
