package com.neagumihai.proiectpibddata.model;

import javax.persistence.*;
import java.util.Objects;

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

    @ManyToOne
    @MapsId("id_elev")
    @JoinColumn(name = "id_elev")
    private Elev elev;

    @ManyToOne
    @MapsId("id_tema")
    @JoinColumn(name = "id_tema")
    private Tema tema;

    @Column(name = "link_tema")
    private String link_tema;


    public String getLink_tema() {
        return link_tema;
    }

    public void setLink_tema(String link_tema) {
        this.link_tema = link_tema;
    }

    public Elev getElev() {
        return elev;
    }

    public void setElev(Elev elev) {
        this.elev = elev;
        this.idElev = elev.getId();
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
         this.tema = tema;
         this.idTema = tema.getId();
    }

    public Integer getIdElev() {
        return idElev;
    }

    public void setIdElev(Integer idElev) {
        this.idElev = idElev;
    }

    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElevTema elevTema = (ElevTema) o;
        return Objects.equals(idElev, elevTema.idElev) && Objects.equals(idTema, elevTema.idTema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idElev, idTema);
    }


}
