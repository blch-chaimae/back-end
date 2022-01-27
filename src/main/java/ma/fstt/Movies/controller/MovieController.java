package ma.fstt.Movies.controller;

import ma.fstt.Movies.model.Movie;
import ma.fstt.Movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("")
    List<Movie> index() {
        return movieRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Movie create(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
    @PutMapping("{id}")
    Movie update(@PathVariable String id, @RequestBody Movie movie) {
        Movie movieFromDB = movieRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        movieFromDB.setPoster_link(movie.getPoster_link());
        movieFromDB.setSeries_title(movie.getSeries_title());
        movieFromDB.setReleased_year(movie.getReleased_year());
        movieFromDB.setCertificate(movie.getCertificate());
        movieFromDB.setRuntime(movie.getRuntime());
        movieFromDB.setGenre(movie.getGenre());
        movieFromDB.setRating(movie.getRating());
        movieFromDB.setOverview(movie.getOverview());
        movieFromDB.setMeta_score(movie.getMeta_score());
        movieFromDB.setDirector(movie.getDirector());
        movieFromDB.setStar1(movie.getStar1());
        movieFromDB.setStar1(movie.getStar2());
        movieFromDB.setStar1(movie.getStar3());
        movieFromDB.setStar1(movie.getStar4());
        movieFromDB.setNo_of_votes(movie.getNo_of_votes());
        movieFromDB.setGross(movie.getGross());
        movieFromDB.setCluster(movie.getCluster());

        return movieRepository.save(movieFromDB);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        Movie movie = movieRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        movieRepository.delete(movie);
    }

}
