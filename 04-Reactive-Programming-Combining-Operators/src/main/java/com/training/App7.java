package com.training;

import reactor.core.publisher.Mono;

public class App7 {
	
	static int attempt = 0;


	public static void main(String[] args) {
		
		  Mono<String> unreliableService = Mono.fromSupplier(() -> {
	            attempt++;
	            System.out.println("Attempt: " + attempt);
	            if (attempt < 3) {
	                throw new RuntimeException("Service failed");
	            }
	            return "Success!";
	        });

	        unreliableService
	                .retry(2)  // Retry 2 times
	                .subscribe(
	                        System.out::println,
	                        error -> System.out.println("Final Error: " + error)
	                );
	}

}
