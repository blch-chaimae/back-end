package ma.fstt.Movies.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Movie {
    @Id
    private String id;
    private String poster_link;
    private String series_title;
    private Long released_year;
    private String certificate;
    private String runtime;
    private String genre;
    private Double rating;
    private String overview;
    private Long meta_score;
    private String director;
    private String star1;
    private String star2;
    private String star3;
    private String star4;
    private Long no_of_votes;
    private String gross;
    private Integer cluster;


}
