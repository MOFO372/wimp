package com.libertymutual.goforcode.wimp.controllers;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;

public class ActorModelTests {
	
	Actor actor; 
	
	@Before
	public void setUp() {
		actor = new Actor(); 
	}	
	
	@Test
	public void test_constructor_setUp() {
		//arrange
		
		//act
		Actor actual = new Actor("Will", "Ferrel", 1994, new Date(Date.parse("07/16/1967")));
			
		//assert
		assertThat(actual.getFirstName()).isEqualTo("Will"); 
		assertThat(actual.getLastName()).isEqualTo("Ferrel"); 
		assertThat(actual.getActiveSinceYear()).isEqualTo(1994); 
		assertThat(actual.getBirthDate()).isEqualTo(new Date(Date.parse("07/16/1967"))); 
		
	}

	@Test
	public void test_get_and_set_id() {
		//arrange
		actor.setId(12L);
		
		//act
		actor.getId(); 
		
		//assert
		assertThat(actor.getId()).isEqualTo(12L); 		
	}
	
	@Test
	public void test_get_and_set_FirstName() {
		//arrange
		actor.setFirstName("Mo"); 
		
		//act
		actor.getFirstName(); 
		
		//assert
		assertThat(actor.getFirstName()).isEqualTo("Mo"); 
	}
	
	
	@Test
	public void test_get_and_set_LastName() {
		//arrange
		actor.setLastName("Fo"); 
		
		//act 
		actor.getLastName(); 
		
		//assert
		assertThat(actor.getLastName()).isEqualTo("Fo"); 
	}
	
	@Test
	public void test_get_and_set_ActiveSinceYear() {
		//arrange
		actor.setActiveSinceYear(1969L); 
		
		//act
		actor.getActiveSinceYear(); 
		
		//assert
		assertThat(actor.getActiveSinceYear()).isEqualTo(1969L); 
	}
	
	
	@Test
	public void test_get_and_set_BirthDate() {
		//arrange
		actor.setBirthDate(new Date(Date.parse("07/16/1967")));
		
		//act
		actor.getBirthDate(); 
		
		//assert
		assertThat(actor.getBirthDate()).isEqualTo(new Date(Date.parse("07/16/1967"))); 
		
	}
	
	
	@Test
	public void test_get_and_set_Movies() {
		//arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		actor.setMovies(movies);
		
		//act
		actor.getMovies(); 
		
		//assert
		assertThat(actor.getMovies()).isSameAs(movies); 
		
	}
	


}
