package net.roozbe.imdb.controller;

import net.roozbe.imdb.mapper.MovieMapper;
import net.roozbe.imdb.model.MovieModel;
import net.roozbe.imdb.model.response.MovieResponseList;
import net.roozbe.imdb.service.ImdbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ImdbController.class)
class ImdbControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImdbService imdbService;

    @MockBean
    private MovieMapper movieMapper;

    @MockBean
    private ApiLoggingAdvice apiLoggingAdvice;

    @Test
    void testGetTitlesWithSameDirectorAndWriterAlive() throws Exception {
        // Arrange
        List<MovieModel> mockModels = new ArrayList<>();
        MovieResponseList mockResponse = new MovieResponseList(new ArrayList<>());

        when(imdbService.getMoviesWithSameDirectorAndWriterAlive(0, 10)).thenReturn(mockModels);
        when(movieMapper.toMovieResponseList(mockModels)).thenReturn(mockResponse.getMovies());

        // Act & Assert
        mockMvc.perform(get("/api/imdb/same-alive-director-writer")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movies").isArray());

        verify(imdbService, times(1)).getMoviesWithSameDirectorAndWriterAlive(0, 10);
        verify(movieMapper, times(1)).toMovieResponseList(mockModels);
    }

    @Test
    void testGetMovieByActors() throws Exception {
        // Arrange
        String actorNames = "Leonardo DiCaprio,Joseph Gordon-Levitt";
        List<MovieModel> mockModels = new ArrayList<>();
        MovieResponseList mockResponse = new MovieResponseList(new ArrayList<>());

        when(imdbService.findMovieByActors(actorNames)).thenReturn(mockModels);
        when(movieMapper.toMovieResponseList(mockModels)).thenReturn(mockResponse.getMovies());

        // Act & Assert
        mockMvc.perform(get("/api/imdb/actors")
                        .param("actorNames", actorNames))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movies").isArray());

        verify(imdbService, times(1)).findMovieByActors(actorNames);
        verify(movieMapper, times(1)).toMovieResponseList(mockModels);
    }

    @Test
    void testGetBestMovieByGenre() throws Exception {
        // Arrange
        String genre = "Drama";
        List<MovieModel> mockModels = new ArrayList<>();
        MovieResponseList mockResponse = new MovieResponseList(new ArrayList<>());

        when(imdbService.findBestGenreOrderByYear(genre)).thenReturn(mockModels);
        when(movieMapper.toMovieResponseList(mockModels)).thenReturn(mockResponse.getMovies());

        // Act & Assert
        mockMvc.perform(get("/api/imdb/movies/best-by-genre")
                        .param("genre", genre))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movies").isArray());

        verify(imdbService, times(1)).findBestGenreOrderByYear(genre);
        verify(movieMapper, times(1)).toMovieResponseList(mockModels);
    }
}