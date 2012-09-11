package com.tmkm.tellmeajoke.model;

import java.util.List;

import com.tmkm.tellmeajoke.dao.JokeDAO;
import com.tmkm.tellmeajoke.entities.Joke;

public class JokeServiceImpl implements JokeService{

	@Override
	public List<Joke> getListOfJokes() {
		JokeDAO jokeDAO = new JokeDAO();
		return jokeDAO.getJokes();
	}

	@Override
	public Joke getRandomJoke() {
		JokeDAO jokeDAO = new JokeDAO();
		List<Joke> jokes = jokeDAO.getJokes();

		if (jokes != null && !jokes.isEmpty()) {
			int index = (int) (Math.random() * 100 / (jokes.size() - 1));
			return jokes.get(index);
		} else {
			return null;
		}
	}
}
