package com.libertymutual.goforcode.wimp.api;

import java.util.Date;
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

import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	private MovieRepository movieRepo; 
	
	public MovieController (MovieRepository movieRepo) {
		this.movieRepo = movieRepo; 
		
		movieRepo.save(new Movie("Blades of Glory", new Date(Date.parse("03/30/2007")), 236295729957l, "Dreamworks"));
		movieRepo.save(new Movie("Anchorman", new Date(Date.parse("07/09/2004")), 4, "Dreamworks"));
	}
	
	@GetMapping("")
	public List<Movie> getAll() {
		return movieRepo.findAll(); 
	}
	
	@GetMapping("{id}") 
	public Movie getOne(@PathVariable long id) throws NotFoundBitchException {
		Movie movie = movieRepo.findOne(id);
		if(movie == null) {
			throw new NotFoundBitchException(); 
		}
		return movieRepo.findOne(id); 
	}
		
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

	@PostMapping("")
	public Movie movie(@RequestBody Movie movie) {
		return movieRepo.save(movie);
	}
	
	@PutMapping("{id}")
	public Movie update(@RequestBody Movie movie, @PathVariable long id) {
		movie.setId(id);
		return movieRepo.save(movie); 
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
