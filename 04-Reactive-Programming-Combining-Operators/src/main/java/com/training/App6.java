package com.training;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class App6 {

	public static void main(String[] args) {
		 Flux.just(1, 2, 0, 4)
         .map(i -> 10 / i)   // Division by zero when i = 0
         .onErrorContinue((error, value) -> {
             System.out.println("Error: " + error);
             System.out.println("Skipping value: " + value);
         })
         .subscribe(System.out::println);
	}

}
