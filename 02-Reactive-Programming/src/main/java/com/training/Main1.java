package com.training;

import reactor.core.publisher.Flux;

public class Main1 {

	public static void main(String[] args) {
		Flux<Integer> numbers = Flux.range(1, 5);

        numbers.map(n -> n * 10)
               .subscribe(System.out::println);

	}

}
