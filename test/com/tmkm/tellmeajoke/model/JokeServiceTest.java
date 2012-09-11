package com.tmkm.tellmeajoke.model;

import org.junit.Before;

import com.tmkm.tellmeajoke.dao.JokeDAO;
import com.tmkm.tellmeajoke.entities.Joke;

public class JokeServiceTest {

	JokeService jokeService;
	JokeDAO jokeDao;
	
	@Before
	public void initVars(){
		jokeService = new JokeServiceImpl();
		jokeDao = new JokeDAO();
	}

	
	//verify if it is being able to select all jokes
	public void selectARandomJoke(){
		Joke joke = jokeService.getRandomJoke();
		//if joke dir is not empty, joke cannot be null
		
	}
}
