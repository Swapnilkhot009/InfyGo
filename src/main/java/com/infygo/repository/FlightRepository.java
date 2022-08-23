package com.infygo.repository;


import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infygo.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String>{

	@Query
	public Set<Flight> findBySourceAndDestinationAndFlightAvailableDate(String source, String destination, LocalDate localDate);



}
