package com.rappi.partidoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.rappi.partidoservice.model.Campeonato;
import com.rappi.partidoservice.model.Equipo;

public interface EquipoRepository  extends  MongoRepository<Equipo, String> {
	
	Equipo findEquipoById(String EquipoId);

}
