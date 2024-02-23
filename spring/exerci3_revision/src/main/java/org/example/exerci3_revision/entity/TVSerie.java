package org.example.exerci3_revision.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class TVSerie {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String gendra;


    @OneToMany(mappedBy = "tvSerie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasonList;

    private boolean status;

    public List<Season> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(List<Season> seasonList) {
        this.seasonList = seasonList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGendra() {
        return gendra;
    }

    public void setGendra(String gendra) {
        this.gendra = gendra;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

