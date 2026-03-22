package com.training.demo.rest;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/numbers")
public class NumbersController {
	
	@GetMapping("/fourNumbers")
	public List<Integer> get4Numbers(){
		List<Integer> intList=new LinkedList<>();
		for(int i=1; i<=4; i++) {
			intList.add(i);
			System.out.println(i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		return intList;
	}
	
	@GetMapping("/flux")
	public Flux<Integer> getNumbers(){
		return Flux.just(1,2,3,4).delayElements(Duration.ofSeconds(5)).log();
	}
	
	@GetMapping(value="/fluxStream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> getNumbersStream(){
		return Flux.just(1,2,3,4).delayElements(Duration.ofSeconds(5)).log();
	}
	
	@GetMapping(value="/fluxStream1")
	public Flux<Integer> f3(){
		return Flux.range(1, 10).delayElements(Duration.ofSeconds(1))
				.doOnNext(System.out::println)
				.map(i->i);
	}
}
