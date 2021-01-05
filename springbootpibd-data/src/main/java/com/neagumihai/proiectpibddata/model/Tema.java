package com.neagumihai.proiectpibddata.model;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Numele nu poate fi gol")
    @Size(min = 2, max = 20, message = "Numele trebuie sa contona intre 2 si 20 de caractere")
    @Column(name = "nume_tema")
    private String numeTema;

    @NotBlank(message = "Numele nu poate fi gol")
    @Size(min = 2, max = 20, message = "Numele trebuie sa contona intre 2 si 20 de caractere")
    @Column(name = "nume_culegere")
    private String numeCulegere;

    @NotNull(message = "Alegeti un numar valid")
    @Min(value = 1,message = "Alegeti un numar pozitiv")
    @Column(name = "numar_tema")
    private Integer numarTema;

    @NotBlank(message = "cerinta nu poate fi goala")
    @Column(name = "cerinta_tema", columnDefinition = "MEDIUMTEXT")
    private String cerintaTema;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Trebuie sa alegeti o dificultate valida")
    @Column(name = "dificultate", columnDefinition = "ENUM('USOR','MEDIU','GREU')")
    private Dificultate dificultate;

    @NotNull(message = "Alegeti un numar corect de puncte")
    @Column(name = "puncte")
    @Min(value = 1, message = "Introduceti un numar pozitiv de puncte")
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

    @Override
    public String toString() {
        return "Tema{" +
                "id=" + id +
                ", numeTema='" + numeTema + '\'' +
                ", numeCulegere='" + numeCulegere + '\'' +
                ", numarTema=" + numarTema +
                ", cerintaTema='" + cerintaTema + '\'' +
                ", dificultate=" + dificultate +
                ", puncte=" + puncte +
                ", elevTemaSet=" + elevTemaSet +
                '}';
    }
}
