package com.airlineservice.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlineservice.app.model.Airline;
import com.airlineservice.app.repositories.ReactiveAirlineRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveAirlineService {

	@Autowired
	ReactiveAirlineRepository airlinerepo;
	
	public Mono<Airline> addAirline(Airline airline)
	{
		return airlinerepo.insert(airline);
	}
	
	public Flux<Airline> getAllAirlines()
			{
		return airlinerepo.findAll();
			}
	public Mono<Airline> updateAirlineData(Airline airline, String airlineId)
	{
		return findOne(airlineId).doOnSuccess(airline1 ->{
			airline1.setAirlineContact(airline.getAirlineContact());
			airline1.setAirlineAddress(airline.getAirlineAddress());
			airline1.setAirlineName(airline.getAirlineName());
			airlinerepo.save(airline1).subscribe();
		});
	}
	public Mono<Airline> findOne(String airlineId) {
        return airlinerepo.findByAirlineId(airlineId).
                switchIfEmpty(Mono.error(new Exception("No Airline with the Id" + airlineId)));
	}
	
	public Mono<Void> deleteAirline(String airlineId)
	{
		return airlinerepo.deleteById(airlineId);
	}
	
}
