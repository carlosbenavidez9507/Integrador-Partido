package com.rappi.partidoservice.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Document(collection="Partido")
public class Partido {
	@Id
	private String id;
	private Date fecha;
	private String estado;
	private String estadio;
	private String idEquipoLocal;
	private String nombreEquipoLocal;
	private String idEquipoVisitante;
	private String nombreEquipoVisitante;
	private Equipo local;
	private Equipo visitante;
	private int fechaCampeonato;
	private boolean favorito;
	
	
	

}
