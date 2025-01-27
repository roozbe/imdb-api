package net.roozbe.imdb.da.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "title_crew")
@Data
public class TitleCrewEntity implements Serializable {

    @EmbeddedId
    private TitleCrewId id;

    @ManyToOne
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", nullable = false,insertable = false, updatable = false)
    private TitleEntity title;

    @Column(name = "directors")
    private String directors;

    @Column(name = "writers")
    private String writers;
}
