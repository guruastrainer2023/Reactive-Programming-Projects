package com.training.demo.handler;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class HelloHandler {

	
	 /**
	   * Serves a plain_text
	   */
	  public Mono<ServerResponse> monoMessage(ServerRequest request) {
	    return ServerResponse.ok()
	      .contentType(MediaType.TEXT_PLAIN)
	      .body(
	        Mono.just("Welcome to JstoBigdata.com"), String.class
	      );
	  }
	  
	 /**
	   * Serves a JSON stream
	   */
	  public Mono<ServerResponse> fluxMessage(ServerRequest request) {
	    return ServerResponse.ok()
	      .contentType(MediaType.APPLICATION_STREAM_JSON)
	      .body(
	        Flux.just("Welcome ", "to ", "JstoBigdata.com")
	          .delayElements(Duration.ofSeconds(10)).log(), String.class
	      );
	  }
}
