package net.roozbe.imdb.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovieResponse {
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private String genres;
    private Integer numVotes;
    private BigDecimal averageRating;
}