package com.training;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class App2 {

	public static void main(String[] args) throws InterruptedException {
		Flux<String> flux1 = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));

        Flux<String> flux2 = Flux.just("1", "2", "3")
                .delayElements(Duration.ofMillis(150));

        Flux.concat(flux1, flux2)
                .subscribe(System.out::println);

        Thread.sleep(1000);

	}

}
