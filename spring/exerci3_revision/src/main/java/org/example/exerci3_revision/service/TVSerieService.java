package org.example.exerci3_revision.service;

import org.example.exerci3_revision.entity.Season;
import org.example.exerci3_revision.entity.TVSerie;
import org.example.exerci3_revision.repository.SeasonRepository;
import org.example.exerci3_revision.repository.TVSerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TVSerieService {

    private final TVSerieRepository tvSerieRepository;

    private final SeasonRepository seasonRepository;

    public TVSerieService(TVSerieRepository tvSerieRepository, SeasonRepository seasonRepository) {
        this.tvSerieRepository = tvSerieRepository;
        this.seasonRepository = seasonRepository;
    }

    public TVSerie addSeason(Long tvSerieId, Season season) {
        TVSerie tvSerie = (TVSerie) tvSerieRepository.findById(tvSerieId)
                .orElseThrow(() -> new IllegalArgumentException("Série TV introuvable avec l'identifiant : " + tvSerieId));
        season.setTvSerie(tvSerie);
        List<Season> seasonList = tvSerie.getSeasonList();
        seasonList.add(season);
        tvSerie.setSeasonList(seasonList);
        seasonRepository.save(season);
        return tvSerieRepository.save(tvSerie);
    }
}
