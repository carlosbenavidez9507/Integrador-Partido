package com.rappi.partidoservice.controller;

import jdk.nashorn.internal.parser.JSONParser;



import com.rappi.partidoservice.model.Campeonato;
import com.rappi.partidoservice.model.Equipo;
import com.rappi.partidoservice.model.Jugador;
import com.rappi.partidoservice.model.Partido;
import com.rappi.partidoservice.repository.CampeonatoRepository;
import com.rappi.partidoservice.repository.EquipoRepository;
import com.rappi.partidoservice.repository.JugadorRepository;
import com.rappi.partidoservice.repository.PartidoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
public class PartidoController {
	

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	 @Autowired
	 private PartidoRepository partidoRepository;
	 
	 @Autowired
	 private CampeonatoRepository campeonatoRepository;
	 
	 @Autowired
	 private EquipoRepository equipoRepository;
	 
	 @Autowired
	 private JugadorRepository jugadorRepository;
	 
	
	 
	 @PostMapping(value = "/partido")
		public Partido save (@RequestBody Partido partido){
			return partidoRepository.save(partido);
		}
	 
	 @GetMapping(value = "/partido")
		public Iterable<Partido> all (){
          
		 List<Partido>partidos=partidoRepository.findAll();
		 for(int i=0;i<partidos.size();i++)
		 {
			 Partido partido=partidos.get(i);
			 Equipo local=equipoRepository.findEquipoById(partido.getIdEquipoLocal());
			 Equipo visitante=equipoRepository.findEquipoById(partido.getIdEquipoVisitante());
			 partido.setLocal(local);
			 partido.setVisitante(visitante);
			 partidos.set(i,partido);
		 }
		 
		 
		 return partidos;
		}
	 
	 @GetMapping(value="/partido/{idPartido}")
	 public Partido getPartidoByIdPartido(@PathVariable String idPartido)
	 {
		 Partido partido=partidoRepository.findPartidoById(idPartido);
		 Equipo local=equipoRepository.findEquipoById(partido.getIdEquipoLocal());
		 Equipo visitante=equipoRepository.findEquipoById(partido.getIdEquipoVisitante());
		 partido.setLocal(local);
		 partido.setVisitante(visitante);
		 
		 return partido;
	 }
	 
	
	 
	 /*
	 @GetMapping(value="/partido/apostador/{idApostador}")
	 public List<Partido> getTableroApostador(@PathVariable String idApostador) throws JSONException
	 {    List<Partido>partidos=partidoRepository.findAll();
	      Campeonato liga=campeonatoRepository.findCampeonatoById("5d700d6caa2e000b3c4ee2a4");
	     
	      Object answer=restTemplate.getForObject("http://apostador-service/apostador/{idApostador}/destacado",Object.class,idApostador);
	      String respuesta=(String)answer;
	      int i = respuesta.indexOf("{");
		 respuesta = respuesta.substring(i);
		  JSONObject jsonFile = new JSONObject(respuesta);
		  
			//apostador.setApuesta(apuestaHecha);
			//apostador.setDetalle(jsonFile);
			//JSONObject tmp=jsonFile.getJSONObject("partido");
			
	      
		 return null;
	 }
	 */
	 @GetMapping(value="/partido/estado/{estadoPartido}")
	 public List<Partido> getPartidosByEstados(@PathVariable String estadoPartido)
	 {
		 return  partidoRepository.findPartidoByEstado(estadoPartido);
		 
		
	 }
	 
	 
	 @PutMapping(value = "/partido")
		public Partido update (@RequestBody Partido partido){
			return partidoRepository.save(partido);
		}
	 
	 @DeleteMapping(value = "/partido")
		public void delete (@RequestBody Partido partido){
		 partidoRepository.delete(partido);
		}
	 
	 @PostMapping(value = "/campeonato")
		public Campeonato save (@RequestBody Campeonato campeonato){
			return campeonatoRepository.save(campeonato);
		}
	 
	 @GetMapping(value = "/campeonato")
		public Iterable<Campeonato> allCampeonatos (){
			return campeonatoRepository.findAll();
		}
	 
	 @PutMapping(value = "/campeonato")
		public Campeonato updateCampeonato (@RequestBody Campeonato campeonato){
			return campeonatoRepository.save(campeonato);
		}
	 
	 @DeleteMapping(value = "/campeonato")
		public void deleteCampeonato (@RequestBody Campeonato campeonato){
		 campeonatoRepository.delete(campeonato);
		}
	 
	 
	 @PostMapping(value = "/equipo")
		public Equipo saveEquipo (@RequestBody Equipo equipo){
			return equipoRepository.save(equipo);
		}
	 
	 
	 @GetMapping(value = "/equipo")
		public Iterable<Equipo> allEquipos (){
			return equipoRepository.findAll();
		}
	 
	 @GetMapping(value = "/equipo/{idEquipo}")
		public Equipo euqipoById (@PathVariable String idEquipo){
			//return equipoRepository.findAll();
		 Equipo equipo=equipoRepository.findEquipoById(idEquipo);
		 return equipo;
		}
	 
	 
	 @PutMapping(value = "/equipo")
		public Equipo updateEquipo (@RequestBody Equipo equipo){
			return equipoRepository.save(equipo);
		}
	 
	 @DeleteMapping(value = "/equipo")
		public void deleteEquipo (@RequestBody Equipo equipo){
		 equipoRepository.delete(equipo);
		}
	 
	 
	 @PostMapping(value = "/jugador")
		public Jugador saveJugador (@RequestBody Jugador jugador){
			return jugadorRepository.save(jugador);
		}
	 
	 @GetMapping(value = "/jugador")
		public Iterable<Jugador> allJugadores (){
			return jugadorRepository.findAll();
		}
	 
	 @PutMapping(value = "/jugador")
		public Jugador updateJugador (@RequestBody Jugador jugador){
			return jugadorRepository.save(jugador);
		}
	 
	 @DeleteMapping(value = "/jugador")
		public void deleteEquipo (@RequestBody Jugador jugador){
		 jugadorRepository.delete(jugador);
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
