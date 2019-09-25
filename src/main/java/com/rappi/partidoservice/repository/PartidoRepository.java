package com.rappi.partidoservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rappi.partidoservice.model.Equipo;
import com.rappi.partidoservice.model.Partido;


public interface PartidoRepository extends MongoRepository<Partido, String> {

	
	Partido findPartidoById(String PartidoId);
	List<Partido> findPartidoByEstado(String PartidoEstado);
	
	
	
}
