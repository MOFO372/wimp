package com.libertymutual.goforcode.wimp.controllers;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;

public class MovieModelTests {
	
	Movie movie;
	
	@Before
	public void setUp() {
		movie = new Movie(); 
	}

	@Test
	public void test_constructor_setUp() {
		//arrange
		
		//act
		Movie actual = new Movie("Blades of Glory", new Date(Date.parse("03/30/2007")), 236295729957L, "Dreamworks"); 
		
		//assert
		assertThat(actual.getTitle()).isEqualTo("Blades of Glory"); 
		assertThat(actual.getReleaseDate()).isEqualTo(new Date(Date.parse("03/30/2007"))); 
		assertThat(actual.getBudget()).isEqualTo(236295729957L); 
		assertThat(actual.getDistributor()).isEqualTo("Dreamworks"); 	
	}
	
	@Test
	public void test_addActor_adds_new_actor() {
		//arrange
		Actor actor = new Actor(); 		
		
		//act
		movie.addActor(actor);
		
		//assert
		assertThat(movie.getActors()).contains(actor);
	}
	

	@Test
	public void test_get_and_set_id() {
		//arrange
		movie.setId(4L); 
		
		//act
		movie.getId(); 
		
		//arrange
		assertThat(movie.getId()).isEqualTo(4L); 
	}
	
	@Test
	public void test_get_and_set_title() {
		//arrange
		movie.setTitle("F BOMB"); 
		
		//act
		movie.getTitle(); 
		
		//assert
		assertThat(movie.getTitle()).isEqualTo("F BOMB"); 
	}
	
	@Test
	public void test_get_and_set_ReleaseDate() {
		//arrange
		movie.setReleaseDate(new Date(Date.parse("06/06/2006")));
		
		//act
		movie.getReleaseDate(); 
		
		//assert
		assertThat(movie.getReleaseDate()).isEqualTo(new Date(Date.parse("06/06/2006"))); 
		
	}
	
	@Test
	public void test_get_and_set_budget() {
		//arrange
		movie.setBudget(1300000L);
		
		//act
		movie.getBudget(); 
		
		//assert
		assertThat(movie.getBudget()).isEqualTo(1300000L); 
	}
	
	@Test
	public void test_get_and_set_distributors() {
		//arrange
		movie.setDistributor("Reese's");
		
		//act
		movie.getDistributor(); 
		
		//assert
		assertThat(movie.getDistributor()).isEqualTo("Reese's"); 
	}
	
	@Test
	public void test_get_and_set_Actors() {
		//arrange
		ArrayList<Actor> actors = new ArrayList<Actor>(); 
		movie.setActors(actors); 
		
		//act
		movie.getActors(); 
		
		//assert
		assertThat(movie.getActors()).isSameAs(actors); 
		}

}


























