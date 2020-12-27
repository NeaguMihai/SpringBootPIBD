package com.neagumihai.proiectpibddata.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nume_tema")
    private String numeTema;

    @Column(name = "nume_culegere")
    private String numeCulegere;

    @Column(name = "numar_tema")
    private Integer numarTema;

    @Column(name = "cerinta_tema")
    private String cerintaTema;

    @Column(name = "dificultate")
    private Dificultate dificultate;

    @Column(name = "puncte")
    private Integer puncte;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tema", fetch = FetchType.EAGER)
    private Set<ElevTema> elevTemaSet = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeTema() {
        return numeTema;
    }

    public void setNumeTema(String numeTema) {
        this.numeTema = numeTema;
    }

    public String getNumeCulegere() {
        return numeCulegere;
    }

    public void setNumeCulegere(String numeCulegere) {
        this.numeCulegere = numeCulegere;
    }

    public Integer getNumarTema() {
        return numarTema;
    }

    public void setNumarTema(Integer numarTema) {
        this.numarTema = numarTema;
    }

    public String getCerintaTema() {
        return cerintaTema;
    }

    public void setCerintaTema(String cerintaTema) {
        this.cerintaTema = cerintaTema;
    }

    public Dificultate getDificultate() {
        return dificultate;
    }

    public void setDificultate(Dificultate dificultate) {
        this.dificultate = dificultate;
    }

    public Integer getPuncte() {
        return puncte;
    }

    public void setPuncte(Integer puncte) {
        this.puncte = puncte;
    }

    public Set<ElevTema> getElevTemaSet() {
        return elevTemaSet;
    }

    public void setElevTemaSet(Set<ElevTema> elevTemaSet) {
        this.elevTemaSet = elevTemaSet;
    }
}
