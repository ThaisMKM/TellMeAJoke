package com.tmkm.tellmeajoke.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tmkm.tellmeajoke.entities.Joke;

public class JokeDAO {

	public List<Joke> getJokes() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("TellMeAJoke");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		@SuppressWarnings("unchecked")
		List<Joke> listJokes = (ArrayList<Joke>) manager.createNativeQuery("select * from joke", Joke.class).getResultList();
		
		manager.close();
		factory.close();

		return listJokes;
	}
	
	

}