package com.neagumihai.proiectpibddata.model;

import javax.persistence.*;

@Entity
@Table(name = "elev_tema")
@IdClass(ElevTemaId.class)
public class ElevTema {

    @Id
    @Column(name = "id_elev")
    private Integer idElev;

    @Id
    @Column(name = "id_tema")
    private Integer idTema;

    @Column(name = "link_tema")
    private String link_tema;

    public Integer getIdElev() {
        return idElev;
    }

    public Integer getIdTema() {
        return idTema;
    }

    public String getLink_tema() {
        return link_tema;
    }

    public void setIdElev(Integer idElev) {
        this.idElev = idElev;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    public void setLink_tema(String link_tema) {
        this.link_tema = link_tema;
    }
}
