package com.libertymutual.goforcode.wimp.controllers;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import com.libertymutual.goforcode.wimp.api.ActorController;
import com.libertymutual.goforcode.wimp.api.NotFoundBitchException;
import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;


public class ActorControllerTests {
	 	
	private ActorController controller;
	private ActorRepository actorRepo; 
	
	@Before
	public void setUp() {
		//create a mock actor repository class to be used for testing
		actorRepo = mock(ActorRepository.class); 
		//create a new instance of MovieController each test so we get a new API each time
		controller = new ActorController(actorRepo); 
	}
	
	@Test 
	public void test_getAll_returns_all_actors_returned_by_the_repo() {
		//arrange
		ArrayList<Actor> actors = new ArrayList<Actor>(); 
		actors.add(new Actor());
		actors.add(new Actor());
		
		when(actorRepo.findAll()).thenReturn(actors); 
		
		//act
		List<Actor> actual = controller.getAll(); 
		
		//assert
		assertThat(actual.size()).isEqualTo(2);
		assertThat(actual.get(0)).isSameAs(actors.get(0)); 
		verify(actorRepo).findAll(); 
		
	}
	
	@Test
	public void test_getOne_returns_Actor_returned_from_repo() throws NotFoundBitchException {
		//arrange
		Actor curtis = new Actor(); 
		when(actorRepo.findOne(7L)).thenReturn(curtis); 
		
		//act
		Actor actual = controller.getOne(7L); 
		
		//assert
		assertThat(actual).isSameAs(curtis); 
		verify(actorRepo).findOne(7L); 
	}

	@Test
	public void test_getOne_throws_NotFoundBitchException_when_no_actor_returned_from_repo() {
		try {
			controller.getOne(9L); 
			fail("The controller did not throw the NotFoundBitchException."); 
			
		} catch (NotFoundBitchException nfbe) {
			
		}
	}
	
	@Test
	public void test_delete_returns_actor_deleted_when_found() {
		//arrange
		Actor actor = new Actor(); 
		when(actorRepo.findOne(3L)).thenReturn(actor); 
		
		//act
		Actor actual = controller.deleteOne(3L); 
		
		//assert
		assertThat(actor).isSameAs(actual); 
		verify(actorRepo).delete(3L);
		verify(actorRepo).findOne(3L); 
	}
	
	@Test
	public void test_that_null_is_returned_when_findOne_throws_EmptyResultDataAccessException() {
		//arrange
		when(actorRepo.findOne(2L)).thenThrow(new EmptyResultDataAccessException(0)); 
		
		//act
		Actor actual = controller.deleteOne(2L); 
		
		//assert
		assertThat(actual).isNull();
		verify(actorRepo).findOne(2L); 
	}
	
	@Test
	public void test_actor_is_created_when_actor_is_called() {
		//arrange
		Actor actor = new Actor(); 
		when(actorRepo.save(actor)).thenReturn(actor); 
		
		//act
		Actor actual = controller.actor(actor); 
		
		//assert
		assertThat(actor).isSameAs(actual); 
		verify(actorRepo).save(actor); 
		
	}
	
	@Test
	public void test_actor_is_saved_when_updated_by_id() {
	//arrange
	Actor actor = new Actor(); 
	actor.setId(7L);
	when(actorRepo.save(actor)).thenReturn(actor); 
	
	//act
	Actor actual = controller.update(actor, 7L); 
	
	//assert
	assertThat(actor).isSameAs(actual); 
	verify(actorRepo).save(actor); 
	
	}
}















