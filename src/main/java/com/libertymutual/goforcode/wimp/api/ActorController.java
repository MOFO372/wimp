package com.libertymutual.goforcode.wimp.api;

//import java.sql.Date;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.wimp.models.Actor;
//import com.libertymutual.goforcode.wimp.models.ActorWithMovies;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
	
	private ActorRepository actorRepo; 
	
	public ActorController(ActorRepository actorRepo) {
		this.actorRepo = actorRepo; 
		
//		actorRepo.save(new Actor("Will", "Ferrel", 1994, new Date(Date.parse("07/16/1967"))));
//		actorRepo.save(new Actor("Jon", "Heder", 2005, new Date(Date.parse("10/26/1977"))));
//		actorRepo.save(new Actor("Paul", "Rudd", 1992, new Date(Date.parse("04/06/1969"))));
	}
	
	@GetMapping("") 
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}
	
	
	//change this if want to include movie details
	@GetMapping("{id}") 
	public Actor getOne(@PathVariable long id) throws NotFoundBitchException {
		Actor actor = actorRepo.findOne(id); 
		if(actor == null) {
			throw new NotFoundBitchException(); 
		}
//		ActorWithMovies newActor = new ActorWithMovies(); 
//		newActor.setActiveSinceYear(actor.getActiveSinceYear()); 
//		newActor.setBirthDate(actor.getBirthDate());
//		newActor.setMovies(actor.getMovies());
//		newActor.setFirstName(actor.getFirstName());
//		newActor.setLastName(actor.getLastName());
//		return newActor; 
		return actor;
	}
	
	@DeleteMapping("{id}") 
	public Actor deleteOne(@PathVariable long id) {
		try {
			Actor actor = actorRepo.findOne(id); 
			actorRepo.delete(id);
			return actor; 
		} catch (EmptyResultDataAccessException erdae){
			return null;
		}
	}
	
	@PostMapping("")
	public Actor actor(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}
	
	@PutMapping("{id}")
	public Actor update(@RequestBody Actor actor, @PathVariable long id) {
		actor.setId(id); 
		return actorRepo.save(actor);
	}

}
