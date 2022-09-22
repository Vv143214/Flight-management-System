package com.org.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@EqualsAndHashCode
public class Flight {

	@Id
	private BigInteger flightCode;
	private String airlineName;
	private String source;
	private int seatsAvailable;

}