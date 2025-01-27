package net.roozbe.imdb.da.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "title_principals")
@Data
public class TitlePrincipalsEntity {

    @ManyToOne
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", nullable = false)
    private TitleEntity title;

    @Column(name = "ordering")
    private Integer ordering;

    @Id
    @Column(name = "nconst")
    private String nconst;

    @Column(name = "category")
    private String category;

    @Column(name = "job")
    private String job;

    @Column(name = "characters")
    private String characters;
}
