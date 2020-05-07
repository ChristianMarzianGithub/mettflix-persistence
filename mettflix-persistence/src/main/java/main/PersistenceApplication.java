package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class PersistenceApplication {

	private static final Logger log = LoggerFactory.getLogger(PersistenceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PersistenceApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(MovieRepository repository) {
		return (args) -> {
			repository.save(new Movie((long) 1,"Die Hard","Action","5"));
			repository.save(new Movie((long) 2,"The Big Lebowski","Action","4"));
			repository.save(new Movie((long) 3,"Silence of the Lambs","Action","3"));
			
			
			// fetch all movies
		      log.info("movies found with findAll():");
		      log.info("-------------------------------");
		      for (Movie movie: repository.findAll()) {
		        log.info(movie.toString());
		      }
		      log.info("");
		      
		      
		   // fetch an individual movie by ID
		      Movie movie = repository.findById(1L);
		      log.info("Movie found with findById(1L):");
		      log.info("--------------------------------");
		      log.info(movie.toString());
		      log.info("");

		      // fetch movies by last name
		      log.info("-------------------------------");
		      log.info("-------------------------------");
		      log.info("Movie found with findByName('Die Hard'):");
		      log.info("--------------------------------------------");
		      repository.findByName("Die Hard").forEach(dieHard -> {
		        log.info(dieHard.toString());
		      });
		      
		      
		      // fetch movies by genre
		      log.info("-------------------------------");
		      log.info("-------------------------------");
		      log.info("Movie found with findByGenre('Action'):");
		      log.info("--------------------------------------------");
		      repository.findByGenre("Action").forEach(Action -> {
		        log.info(Action.toString());
		      });
		      
		      // fetch movies by bewertung
		      log.info("-------------------------------");
		      log.info("-------------------------------");
		      log.info("Movie found with findByBewertung('4'):");
		      log.info("--------------------------------------------");
		      repository.findByBewertung("4").forEach(vier -> {
		        log.info(vier.toString());
		      });
		      
		      log.info("");
			
		};
	}

}
