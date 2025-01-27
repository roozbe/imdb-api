package net.roozbe.imdb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MovieResponseList {
    private List<MovieResponse> movies;
}
