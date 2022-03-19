package com.sb.orm.ex.entities;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class Address {
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zipCode;
	
	
}
