package com.training;

import reactor.core.publisher.Flux;

public class App3 {

	public static void main(String[] args) {
		Flux<String> letters = Flux.just("A", "B", "C");
		Flux<Integer> numbers = Flux.just(1, 2, 3);

		Flux.zip(letters, numbers)
		    .subscribe(tuple ->
		        System.out.println(tuple.getT1() + "-" + tuple.getT2())
		    );

	}

}
