package main;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>{
	
	Movie findById(long Id);
	
	List<Movie> findByName(String name);
	
	List<Movie> findByGenre(String genre);
	
	List<Movie> findByBewertung(String bewertung);
}