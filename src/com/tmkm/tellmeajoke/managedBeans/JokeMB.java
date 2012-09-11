package com.tmkm.tellmeajoke.managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.tmkm.tellmeajoke.entities.Joke;
import com.tmkm.tellmeajoke.model.JokeServiceImpl;

@ManagedBean
public class JokeMB {

	private List<Joke> listOfJokes;
	private Joke joke;
		
	public Joke getJoke() {
		return joke;
	}


	public void setJoke(Joke jokeSelected) {
		this.joke = jokeSelected;
	}


	public String tellJoke(){
		setJoke(new JokeServiceImpl().getRandomJoke());		
		return "listJokes";
	}
	
	public String redirectToUploadJokePage(){
		return "insertJoke";
	}
	
	
	
	public String listJokes(){
		setListOfJokes(new JokeServiceImpl().getListOfJokes());		
		return "listJokes";
	}

	public List<Joke> getListOfJokes() {
		return listOfJokes;
	}

	public void setListOfJokes(List<Joke> listOfJokes) {
		this.listOfJokes = listOfJokes;
	}
	
	public String addNewJoke(){
		return "insertJoke";
		//salva no dao os novos dados do joke inserido
		//vem da tela o nome , a pessoa q inseriu e temos tb o jokemb, q salva na pasta a nova joke
		//preciso recuperar o caminho pra joke do fileMB(ainda nao sei como) e entao salvar tudo como um novo joke DAO
	}
	
}
