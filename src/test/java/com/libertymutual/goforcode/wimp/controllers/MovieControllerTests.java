package com.libertymutual.goforcode.wimp.controllers;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import com.libertymutual.goforcode.wimp.api.MovieController;
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
	
	
}
