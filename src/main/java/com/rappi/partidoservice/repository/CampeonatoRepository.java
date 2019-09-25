package com.rappi.partidoservice.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.rappi.partidoservice.model.Campeonato;
import com.rappi.partidoservice.model.Partido;

public interface CampeonatoRepository extends  MongoRepository<Campeonato, String> {
	
	Campeonato findCampeonatoById(String IdCampeonato);

}
