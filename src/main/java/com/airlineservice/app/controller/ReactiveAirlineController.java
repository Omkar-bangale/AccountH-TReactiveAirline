package com.airlineservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airlineservice.app.services.ReactiveAirlineService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.airlineservice.app.model.Airline;

@RestController
public class ReactiveAirlineController {
	
	@Autowired
	private ReactiveAirlineService airlineservice;
	
	@GetMapping("/reactiveairline/getall")
	public Flux<Airline> getAllAirlines()
	{
		return airlineservice.getAllAirlines();
	}
	
	@PostMapping("/reactiveairline/postairline")
	public Mono<Airline> addAirline(@RequestBody Airline airline)
	{
		return airlineservice.addAirline(airline);
	}
	
	@PutMapping("/reactiveairline/update/{airlineId}")
	public Mono<Airline> updateAirline(@PathVariable String airlineId, @RequestBody Airline airline)
	{
		return airlineservice.updateAirlineData(airline, airlineId);
	}
	
	@DeleteMapping("/reactiveairline/remove/{airlineId}")
	public Mono<Void> removeAirline(@PathVariable String airlineId)
	{
		return airlineservice.deleteAirline(airlineId);
	}
	
	

}
