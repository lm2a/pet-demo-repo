package com.lm2a.pet.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pet {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phone;
	@Enumerated(EnumType.STRING)
	private Type type;
	
	public static enum Type{
		PERRO, GATO, OTRO
	}

	
	
	
}
