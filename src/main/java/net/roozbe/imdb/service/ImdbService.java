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
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class ImdbService {

    private static final String COMMA_SEPARATOR = ",";
    private final TitleCrewRepository titleCrewRepository;
    private final NameRepository nameRepository;
    private final TitleRepository titleRepository;
    private final RatingRepository ratingRepository;
    private final MovieMapper movieMapper;

    public List<MovieModel> getMoviesWithSameDirectorAndWriterAlive(int page, int size) {
        Integer currentYear = LocalDate.now().getYear();
        List<TitleCrewEntity> titlesWithSameDirectorAndWriter = titleCrewRepository.findTitlesWithSameDirectorAndWriterAlive(currentYear, PageRequest.of(page, size));
        return movieMapper.toMovieModelList(titlesWithSameDirectorAndWriter);
    }

    public List<MovieModel> findMovieByActors(String actorNames) {
        String[] names = actorNames.split(COMMA_SEPARATOR);
        List<NameEntity> nameEntities = nameRepository.findByPrimaryNameIn(Arrays.asList(names));
        List<List<String>> titlesList = new ArrayList<>();
        for (NameEntity nameEntity : nameEntities) {
            if (nameEntity.getKnownForTitles() != null) {
                titlesList.add(Arrays.asList(nameEntity.getKnownForTitles().split(COMMA_SEPARATOR)));
            }
        }
        Set<String> titleCommonElements = findCommonElements(titlesList);
        List<TitleEntity> titleEntities = titleRepository.findByIdInOrderByStartYearAsc(movieMapper.toTitleCrewIdList(titleCommonElements));
        return movieMapper.toMovieModelListFromTitleEntities(titleEntities);
    }

    private static <T> Set<T> findCommonElements(List<List<T>> lists) {
        if (lists == null || lists.isEmpty()) {
            return Collections.emptySet();
        }
        Set<T> common = new HashSet<>(lists.get(0));
        for (List<T> list : lists) {
            common.retainAll(list);
        }
        return common;
    }

    public List<MovieModel> findBestGenreOrderByYear(String genre){
        Set<String> titleIds = ratingRepository.findBestTitlesByGenre(genre);
        List<TitleEntity> titleEntities = titleRepository.findByIdInOrderByStartYearAsc(movieMapper.toTitleCrewIdList(titleIds));
        return movieMapper.toMovieModelListFromTitleEntities(titleEntities);
    }
}