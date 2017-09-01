package com.libertymutual.goforcode.wimp.controllers;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.assertj.core.api.Assertions.*;

import com.libertymutual.goforcode.wimp.api.MovieController;
import com.libertymutual.goforcode.wimp.api.NotFoundBitchException;
import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;



public class MovieControllerTests {

	private MovieRepository movieRepo; 	
	private MovieController controller;
	private ActorRepository actorRepo; 
	
	@Before
	public void setUp() {
		//create a mock movie repository class to be used for testing
		movieRepo = mock(MovieRepository.class);
		actorRepo = mock(ActorRepository.class);
		//create a new instance of MovieController each test so we get a new API each time
		controller = new MovieController(movieRepo, actorRepo); 
	}
	
	@Test
	public void test_getAll_returns_all_movies_returned_by_the_repo() {
		//arrange
		ArrayList<Movie> movies = new ArrayList<Movie>(); 
		movies.add(new Movie()); 
		movies.add(new Movie()); 
		
		when(movieRepo.findAll()).thenReturn(movies); 
		
		//act
		List<Movie> actual = controller.getAll(); 
		
		//assert 
		assertThat(actual.size()).isEqualTo(2); 
		assertThat(actual.get(0)).isSameAs(movies.get(0)); 
		verify(movieRepo).findAll(); 
		
	}
	
	@Test
	public void test_getOne_returns_Movie_returned_from_repo() throws NotFoundBitchException {
		//arrange
		Movie bladesOfGlory = new Movie(); 
		when(movieRepo.findOne(9L)).thenReturn(bladesOfGlory); 
		
		//act
		Movie actual = controller.getOne(9L); 
		
		//assert
		assertThat(actual).isSameAs(bladesOfGlory);
		verify(movieRepo).findOne(9L); 
	}
	
	@Test
	public void test_getOne_throws_NotFoundBitchException_when_no_movie_returned_from_repo() {
		try {
			controller.getOne(4L); 
			fail("The controller did not throw the NotFoundBitchException."); 
		} catch(NotFoundBitchException nfbe) {
			
		}
	}
	
	@Test
	public void test_delete_returns_actor_deleted_when_found() {
		//arrange
		Movie movie = new Movie(); 
		when(movieRepo.findOne(2L)).thenReturn(movie); 
		
		//act
		Movie actual = controller.deleteOne(2L); 
		
		//assert
		assertThat(movie).isSameAs(actual); 
		verify(movieRepo).delete(2L);
		verify(movieRepo).findOne(2L); 
	}
	
	@Test
	public void test_null_is_returned_when_findOne_throws_EmptyResultDataAccessException() {
		//arrange
		when(movieRepo.findOne(1L)).thenThrow(new EmptyResultDataAccessException(0)); 
		
		//act
		Movie actual = controller.deleteOne(1L); 
		
		//assert
		assertThat(actual).isNull(); 
		verify(movieRepo).findOne(1L); 
	}
	
	@Test
	public void test_movie_is_created_when_movie_is_called() {
		//arrange
		Movie movie = new Movie(); 
		when(movieRepo.save(movie)).thenReturn(movie); 
		
		//act
		Movie actual = controller.movie(movie); 
		
		//assert
		assertThat(movie).isSameAs(actual); 
		verify(movieRepo).save(movie); 
	}
	
	@Test
	public void test_movie_is_saved_when_updated_by_id() {
		//arrange
		Movie movie = new Movie(); 
		movie.setId(6L);
		when(movieRepo.save(movie)).thenReturn(movie); 
				
		//act
		Movie actual = controller.update(movie, 7L); 
				
		//assert
		assertThat(movie).isSameAs(actual); 
		verify(movieRepo).save(movie); 
	}
	
	@Test
	public void test_movie_is_associated_with_actors_when_associateAnActor_is_called() {
		//arrange
		Movie movie = new Movie(); 
		Actor actor = new Actor(); 
		when(movieRepo.findOne(3L)).thenReturn(movie); 
		when(actorRepo.findOne(5L)).thenReturn(actor); 
		
		//act
		Movie actual = controller.associateAnActor(3L, actor); 
		
		//assert
		assertThat(movie).isSameAs(actual); 
		verify(movieRepo).save(movie); 
	}
}











































