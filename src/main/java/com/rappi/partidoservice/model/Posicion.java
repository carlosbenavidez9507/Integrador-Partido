package com.rappi.partidoservice.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Posicion {
	
	@Id
	private String id;
	private String equipo;
	private int pj;
	private int pg;
	private int pe;
	private int pp;
	private int pts;

}
