package com.training;

import java.util.concurrent.Flow.Publisher;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;


public class App {
    public static void main(String[] args) {
    	 Flux<Integer> flux = Flux.range(1, 10);

         flux.subscribe(new BaseSubscriber<Integer>() {

             @Override
             protected void hookOnSubscribe(Subscription subscription) {
                 System.out.println("Subscribed");
                 request(2);  // Request only 2 items initially
             }

             @Override
             protected void hookOnNext(Integer value) {
                 System.out.println("Received: " + value);

                 try { Thread.sleep(500); } catch (Exception e) {}

                 request(2);  // Request next 2 items
             }

             @Override
             protected void hookOnComplete() {
                 System.out.println("Completed");
             }
         });
    }
}
