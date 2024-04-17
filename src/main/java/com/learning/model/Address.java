package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Address {

	private double addressId;
	private String houseNo;
	private String street;
	private String locality;
	private String area;
	private int pincode;
	private String state;
	private String country;
	

}
