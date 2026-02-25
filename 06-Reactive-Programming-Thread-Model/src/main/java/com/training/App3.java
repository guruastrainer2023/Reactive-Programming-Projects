package com.training;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Hello world!
 */
public class App3 {
    public static void main(String[] args) throws InterruptedException {
    	
    	Mono.fromCallable(() -> {
    	    System.out.println("Thread 1: " + Thread.currentThread().getName());
    	    return "Data";
    	})
    	.subscribeOn(Schedulers.boundedElastic())
    	.map(data -> {
    	    System.out.println("Thread 2: " + Thread.currentThread().getName());
    	    return data.toUpperCase();
    	})
    	.subscribe(System.out::println);
    	
    	Thread.sleep(5000);

    }
}
