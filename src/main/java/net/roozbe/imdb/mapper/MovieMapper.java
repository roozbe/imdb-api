package net.roozbe.imdb.mapper;


import net.roozbe.imdb.da.entity.TitleCrewEntity;
import net.roozbe.imdb.da.entity.TitleCrewId;
import net.roozbe.imdb.da.entity.TitleEntity;
import net.roozbe.imdb.model.MovieModel;
import net.roozbe.imdb.model.response.MovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    List<MovieResponse> toMovieResponseList(List<MovieModel> models);

    MovieResponse toMovieResponse(MovieModel model);

    List<MovieModel> toMovieModelList(List<TitleCrewEntity> titleCrewList);

    @Mapping(target = "titleType",source = "title.titleType")
    @Mapping(target = "endYear",source = "title.endYear")
    @Mapping(target = "genres",source = "title.genres")
    @Mapping(target = "isAdult",source = "title.isAdult")
    @Mapping(target = "originalTitle",source = "title.originalTitle")
    @Mapping(target = "primaryTitle",source = "title.primaryTitle")
    @Mapping(target = "runtimeMinutes",source = "title.runtimeMinutes")
    @Mapping(target = "startYear",source = "title.startYear")
    @Mapping(target = "averageRating",source = "title.rating.averageRating")
    @Mapping(target = "numVotes",source = "title.rating.numVotes")
    MovieModel toMovieMode(TitleCrewEntity titleCrew);

    List<TitleCrewId> toTitleCrewIdList(Set<String> titleCommonElements);

    @Mapping(target = "tconst",source = "titleCommonElement")
    TitleCrewId toTitleCrewIdList(String titleCommonElement);

    List<MovieModel> toMovieModelListFromTitleEntities(List<TitleEntity> titleEntities);

    @Mapping(target = "titleType",source = "titleType")
    @Mapping(target = "endYear",source = "endYear")
    @Mapping(target = "genres",source = "genres")
    @Mapping(target = "isAdult",source = "isAdult")
    @Mapping(target = "originalTitle",source = "originalTitle")
    @Mapping(target = "primaryTitle",source = "primaryTitle")
    @Mapping(target = "runtimeMinutes",source = "runtimeMinutes")
    @Mapping(target = "startYear",source = "startYear")
    @Mapping(target = "averageRating",source = "rating.averageRating")
    @Mapping(target = "numVotes",source = "rating.numVotes")
    MovieModel toMovieModeFromTitleEntity(TitleEntity titleEntities);
}
