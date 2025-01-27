package net.roozbe.imdb.da.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "titles")
@Data
public class TitleEntity implements Serializable {

    @EmbeddedId
    private TitleCrewId id;

    @Column(name = "title_type")
    private String titleType;

    @Column(name = "primary_title")
    private String primaryTitle;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "is_adult")
    private Boolean isAdult;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "runtime_minutes")
    private Integer runtimeMinutes;

    @Column(name = "genres")
    private String genres;

    @OneToOne(mappedBy = "title",fetch = FetchType.EAGER)
    private RatingEntity rating;
}
