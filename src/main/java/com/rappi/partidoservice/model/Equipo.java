package com.rappi.partidoservice.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Document(collection="Equipo")
public class Equipo {
	
	@Id
	private String id;
	private String nombreEquipo;
	private ArrayList<Jugador> jugador;
	private ArrayList<String> jugadores;
	private String rutaFotoEquipo;
	

}


