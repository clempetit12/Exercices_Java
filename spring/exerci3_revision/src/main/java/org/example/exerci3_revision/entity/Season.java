package org.example.exerci3_revision.entity;

import jakarta.persistence.*;

@Entity
public class Season {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numberSeason;
    private int numberEpisodes;

    @ManyToOne
    @JoinColumn(name = "tvserie_id")
    private TVSerie tvSerie;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getNumberSeason() {
        return numberSeason;
    }

    public void setNumberSeason(int numberSeason) {
        this.numberSeason = numberSeason;
    }

    public int getNumberEpisodes() {
        return numberEpisodes;
    }

    public void setNumberEpisodes(int numberEpisodes) {
        this.numberEpisodes = numberEpisodes;
    }

    public TVSerie getTvSerie() {
        return tvSerie;
    }

    public void setTvSerie(TVSerie tvSerie) {
        this.tvSerie = tvSerie;
    }
}
