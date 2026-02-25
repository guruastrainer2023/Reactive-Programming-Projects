package com.training;

import reactor.core.publisher.Mono;

public class App5 {

	public static void main(String[] args) {
		Mono<Integer> mono = Mono.just(10)
                .map(i -> i / 0)   // Causes ArithmeticException
                .onErrorResume(e -> {
                    System.out.println("Error occurred: " + e);
                    return Mono.just(0);  // fallback value
                });

        mono.subscribe(System.out::println);
	}

}
