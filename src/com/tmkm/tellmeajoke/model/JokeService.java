package com.tmkm.tellmeajoke.model;

import java.util.List;

import com.tmkm.tellmeajoke.entities.Joke;

public interface JokeService {

	public List<Joke> getListOfJokes();
	
	public Joke getRandomJoke();
	
	
	
}
