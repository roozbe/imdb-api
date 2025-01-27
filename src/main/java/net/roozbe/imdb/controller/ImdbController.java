package net.roozbe.imdb.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import net.roozbe.imdb.mapper.MovieMapper;
import net.roozbe.imdb.model.MovieModel;
import net.roozbe.imdb.model.response.MovieResponseList;
import net.roozbe.imdb.service.ImdbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/imdb")
@AllArgsConstructor
public class ImdbController {

    private final ImdbService imdbService;
    private final MovieMapper movieMapper;

    @GetMapping("/same-alive-director-writer")
    public MovieResponseList getTitlesWithSameDirectorAndWriterAlive(@RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "10") int size) {
        List<MovieModel> models = imdbService.getMoviesWithSameDirectorAndWriterAlive(page,size);
        return new MovieResponseList(movieMapper.toMovieResponseList(models));
    }

    @GetMapping("/actors")
    public MovieResponseList getMovieByActors(@Parameter(
            description = "Actor names in comma separated format",
            required = true,
            example = "Leonardo DiCaprio,Joseph Gordon-Levitt"
    )@RequestParam String actorNames){
        List<MovieModel> models = imdbService.findMovieByActors(actorNames);
        return new MovieResponseList(movieMapper.toMovieResponseList(models));
    }

    @GetMapping("/movies/best-by-genre")
    public MovieResponseList getBestMovieByGenre(@Parameter(
            description = "Genre name",
            required = true,
            example = "Drama"
    )@RequestParam String genre){
        List<MovieModel> models = imdbService.findBestGenreOrderByYear(genre);
        return new MovieResponseList(movieMapper.toMovieResponseList(models));
    }
}
