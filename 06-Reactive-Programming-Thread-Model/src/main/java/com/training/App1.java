package com.training;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Hello world!
 */
public class App1 {
    public static void main(String[] args) throws InterruptedException {
    	Mono.just("Reactive")
        .subscribeOn(Schedulers.parallel())
        .map(String::toUpperCase)
        .subscribe(data->{
        	System.out.println(Thread.currentThread().getName());
        	System.out.println(data);
        });
    	
    	Thread.sleep(5000);
    }
}
