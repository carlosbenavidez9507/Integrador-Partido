package com.rappi.partidoservice.model;

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



@Document(collection="Jugador")
public class Jugador {
	@Id
	private String idJugador;
	private String nombreJuador;
	private Integer numero;
	private String idEquipo;
	
	
}
