package net.roozbe.imdb.service;

import net.roozbe.imdb.da.entity.NameEntity;
import net.roozbe.imdb.da.entity.TitleCrewEntity;
import net.roozbe.imdb.da.entity.TitleEntity;
import net.roozbe.imdb.da.repository.NameRepository;
import net.roozbe.imdb.da.repository.RatingRepository;
import net.roozbe.imdb.da.repository.TitleCrewRepository;
import net.roozbe.imdb.da.repository.TitleRepository;
import net.roozbe.imdb.mapper.MovieMapper;
import net.roozbe.imdb.model.MovieModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ImdbServiceTest {

    @Mock
    private TitleCrewRepository titleCrewRepository;

    @Mock
    private NameRepository nameRepository;

    @Mock
    private TitleRepository titleRepository;

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private MovieMapper movieMapper;

    @InjectMocks
    private ImdbService imdbService;

    @Test
    void testGetMoviesWithSameDirectorAndWriterAlive() {
        // Arrange
        int page = 0;
        int size = 10;
        Integer currentYear = LocalDate.now().getYear();
        List<TitleCrewEntity> mockEntities = new ArrayList<>();
        List<MovieModel> mockModels = new ArrayList<>();

        when(titleCrewRepository.findTitlesWithSameDirectorAndWriterAlive(eq(currentYear), eq(PageRequest.of(page, size))))
                .thenReturn(mockEntities);
        when(movieMapper.toMovieModelList(mockEntities)).thenReturn(mockModels);

        // Act
        List<MovieModel> result = imdbService.getMoviesWithSameDirectorAndWriterAlive(page, size);

        // Assert
        assertNotNull(result);
        assertEquals(mockModels, result);
        verify(titleCrewRepository, times(1))
                .findTitlesWithSameDirectorAndWriterAlive(eq(currentYear), eq(PageRequest.of(page, size)));
        verify(movieMapper, times(1)).toMovieModelList(mockEntities);
    }


    @Test
    void testFindMovieByActors() {
        // Arrange
        String actorNames = "Actor1,Actor2";
        List<NameEntity> mockNameEntities = Arrays.asList(
                new NameEntity("nconst1", "Actor1", null, null, null, "tconst1,tconst2"),
                new NameEntity("nconst2", "Actor2", null, null, null, "tconst2,tconst3")
        );
        List<List<String>> mockTitlesList = Arrays.asList(
                Arrays.asList("tconst1", "tconst2"),
                Arrays.asList("tconst2", "tconst3")
        );
        Set<String> mockCommonTitles = new HashSet<>(Collections.singletonList("tconst2"));
        List<TitleEntity> mockTitleEntities = new ArrayList<>();
        List<MovieModel> mockModels = new ArrayList<>();

        when(nameRepository.findByPrimaryNameIn(Arrays.asList("Actor1", "Actor2"))).thenReturn(mockNameEntities);
        when(titleRepository.findByIdInOrderByStartYearAsc(anyList())).thenReturn(mockTitleEntities);
        when(movieMapper.toMovieModelListFromTitleEntities(mockTitleEntities)).thenReturn(mockModels);

        // Act
        List<MovieModel> result = imdbService.findMovieByActors(actorNames);

        // Assert
        assertNotNull(result);
        assertEquals(mockModels, result);
        verify(nameRepository, times(1)).findByPrimaryNameIn(Arrays.asList("Actor1", "Actor2"));
        verify(titleRepository, times(1)).findByIdInOrderByStartYearAsc(anyList());
        verify(movieMapper, times(1)).toMovieModelListFromTitleEntities(mockTitleEntities);
    }

    @Test
    void testFindBestGenreOrderByYear() {
        // Arrange
        String genre = "Drama";
        Set<String> mockTitleIds = new HashSet<>(Arrays.asList("tconst1", "tconst2"));
        List<TitleEntity> mockTitleEntities = new ArrayList<>();
        List<MovieModel> mockModels = new ArrayList<>();

        when(ratingRepository.findBestTitlesByGenre(genre)).thenReturn(mockTitleIds);
        when(titleRepository.findByIdInOrderByStartYearAsc(anyList())).thenReturn(mockTitleEntities);
        when(movieMapper.toMovieModelListFromTitleEntities(mockTitleEntities)).thenReturn(mockModels);

        // Act
        List<MovieModel> result = imdbService.findBestGenreOrderByYear(genre);

        // Assert
        assertNotNull(result);
        assertEquals(mockModels, result);
        verify(ratingRepository, times(1)).findBestTitlesByGenre(genre);
        verify(titleRepository, times(1)).findByIdInOrderByStartYearAsc(anyList());
        verify(movieMapper, times(1)).toMovieModelListFromTitleEntities(mockTitleEntities);
    }

}