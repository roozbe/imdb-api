package net.roozbe.imdb.da.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ratings")
@Data
public class RatingEntity implements Serializable {

    @EmbeddedId
    private TitleCrewId id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst")
    private TitleEntity title;

    @Column(name = "average_rating")
    private BigDecimal averageRating;

    @Column(name = "num_votes")
    private Integer numVotes;
}
