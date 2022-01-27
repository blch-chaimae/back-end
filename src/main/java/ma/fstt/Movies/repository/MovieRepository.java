package ma.fstt.Movies.repository;

import ma.fstt.Movies.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie,String> {
}
