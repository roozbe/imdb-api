package net.roozbe.imdb.da.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "names")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameEntity {

    @Id
    private String nconst;

    @Column(name = "primary_name")
    private String primaryName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;

    @Column(name = "primary_profession")
    private String primaryProfession;

    @Column(name = "known_for_titles")
    private String knownForTitles;
}
