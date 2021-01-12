package com.neagumihai.proiectpibddata.model;

import java.io.Serializable;
import java.util.Objects;

public class ElevTemaId implements Serializable {


    private Integer idElev;

    private Integer idTema;

    public ElevTemaId() {
    }

    public ElevTemaId(Integer idElev, Integer idTema) {
        this.idElev = idElev;
        this.idTema = idTema;
    }

    public Integer getElev() {
        return idElev;
    }

    public void setElev(Integer idElev) {
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
        ElevTemaId that = (ElevTemaId) o;
        return Objects.equals(idElev, that.idElev) && Objects.equals(idTema, that.idTema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idElev, idTema);
    }
}
