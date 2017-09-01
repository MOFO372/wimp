package com.libertymutual.goforcode.wimp.api;

//import java.util.Date;
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
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/movies")
@Api(description="Use this to get and create movies and add actors to movies.")
public class MovieController {
	
	private MovieRepository movieRepo; 
	private ActorRepository actorRepo;
	
	public MovieController (MovieRepository movieRepo, ActorRepository actorRepo) {
		this.movieRepo = movieRepo; 
		this.actorRepo = actorRepo;
		
//		movieRepo.save(new Movie("Blades of Glory", new Date(Date.parse("03/30/2007")), 236295729957l, "Dreamworks"));
//		movieRepo.save(new Movie("Anchorman", new Date(Date.parse("07/09/2004")), 4, "Dreamworks"));
	}
	
	@ApiOperation(value="create a list of movies.")
	@GetMapping("")
	public List<Movie> getAll() {
		return movieRepo.findAll(); 
	}
	
	@ApiOperation(value="get one movie based on movie ID.")
	@GetMapping("{id}") 
	public Movie getOne(@PathVariable long id) throws NotFoundBitchException {
		Movie movie = movieRepo.findOne(id);
		if(movie == null) {
			throw new NotFoundBitchException(); 
		}
		return movie; 
	}
		
	@ApiOperation(value="delete one movie based on movie ID.")
	@DeleteMapping("{id}")
	public Movie deleteOne(@PathVariable long id) {
		try {
			Movie movie = movieRepo.findOne(id);
			movieRepo.delete(id);
			return movie;
		} catch (EmptyResultDataAccessException erdae) {
			return null; 
		}
	}

	@ApiOperation(value="create a new movie.")
	@PostMapping("")
	public Movie movie(@RequestBody Movie movie) {
		return movieRepo.save(movie);
	}
	

	@ApiOperation(value="update one movie based on movie ID.")
	@PutMapping("{id}")
	public Movie update(@RequestBody Movie movie, @PathVariable long id) {
		movie.setId(id);
		return movieRepo.save(movie); 
	}
	
	@ApiOperation(value="associates actors with movies.")
	@PostMapping("/{movieId}/actors")
	public Movie associateAnActor(@PathVariable long movieId, @RequestBody Actor actor) {
		Movie movie = movieRepo.findOne(movieId);
		actor = actorRepo.findOne(actor.getId());
		
		movie.addActor(actor); 
		movieRepo.save(movie); 
		
		return movie;
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
