package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String genre;
	private String bewertung;
	
	protected Movie() {}
	
	public Movie(Long id, String name, String genre, String bewertung) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.bewertung = bewertung;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Movie[id='%d', name='%s', genre='%s', bewertung='%s']", id,name,genre,bewertung			
				);
	}
	
	
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getGenre() {
		return genre;
	}
	
	public String getBewertung() {
		return bewertung;
	}
}
