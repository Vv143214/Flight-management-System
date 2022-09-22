package com.org.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Airport {
	@Id
	private String airportCode;
	private String airportLocation;
	private String airportName;


}