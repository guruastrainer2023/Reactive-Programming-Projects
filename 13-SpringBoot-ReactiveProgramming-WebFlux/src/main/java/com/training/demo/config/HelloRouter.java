package com.training.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.training.demo.handler.HelloHandler;

@Configuration
public class HelloRouter {
	
	@Bean
	  public RouterFunction<ServerResponse> functionalRoutes(HelloHandler helloHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.GET("/functional/mono")
	        , helloHandler::monoMessage)
	      .andRoute(RequestPredicates.GET("functional/flux")
	        , helloHandler::fluxMessage);
	  }

}
