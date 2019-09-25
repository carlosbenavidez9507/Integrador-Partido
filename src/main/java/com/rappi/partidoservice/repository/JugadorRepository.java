package com.rappi.partidoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rappi.partidoservice.model.Campeonato;
import com.rappi.partidoservice.model.Jugador;

public interface JugadorRepository  extends  MongoRepository<Jugador, String> {

}
