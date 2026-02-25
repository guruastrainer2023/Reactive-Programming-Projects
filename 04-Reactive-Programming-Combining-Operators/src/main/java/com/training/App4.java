package com.training;

import reactor.core.publisher.Flux;

public class App4 {

	public static void main(String[] args) {
		Flux<String> letters = Flux.just("A", "B", "C");
		Flux<Integer> numbers = Flux.just(1, 2, 3);
		
		Flux.combineLatest(letters, numbers,
		        (l, n) -> l + ":" + n)
		    .subscribe(System.out::println);
	}

}
