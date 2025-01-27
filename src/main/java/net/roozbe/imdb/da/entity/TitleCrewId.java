package net.roozbe.imdb.da.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class TitleCrewId implements Serializable {
    private String tconst;
}
