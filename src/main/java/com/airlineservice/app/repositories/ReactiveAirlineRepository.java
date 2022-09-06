package com.airlineservice.app.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.airlineservice.app.model.Airline;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ReactiveAirlineRepository extends ReactiveMongoRepository<Airline, String> {

	

	  Mono<Airline> findByAirlineId(String airlineId);
}
