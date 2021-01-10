package com.neagumihai.proiectpibddata.model;


import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "elev")
public class Elev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @NotBlank(message = "Numele nu poate fi gol")
    @Size(min = 2, max = 20, message = "Numele trebuie sa contona intre 2 si 20 de caractere")
    @Column(name = "nume")
    private String nume;

    @NotBlank(message = "Prenumele nu poate fi gol")
    @Size(min = 2, max = 20 , message = "Prenumele trebuie sa contona intre 2 si 20 de caractere")
    @Column(name = "prenume")
    private String prenume;

    @NotNull(message = "Introduceti o data valida de forma dd-MM-yyyy")
    @Past(message = "Data trebuie sa fie valida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_nastere")
    private Date dataNastere;

    @NotBlank(message = "Campul clasa nu poate fi gol")
    @Size(min = 1, max = 5, message = "clasa trebuie sa contona intre 2 si 5 caractere")
    @Column(name = "clasa")
    @Pattern(regexp = "(^[1-9][A-Z]{1}$|(^[1][0-9][A-Z]{1}$))", message = "Introdu clasa sub forma : 13F, 5C, etc.")
    private String clasa;

    @NotBlank(message = "Campul scoala nu poate fi gol")
    @Size(min = 2, max = 20, message = "Scoala trebuie sa contona intre 2 si 20 de caractere")
    @Column(name = "scoala")
    private String scoala;

    @Column(name = "puncte")
    private Integer puncte;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elev", fetch = FetchType.EAGER)

    private Set<ElevTema> elevTemaSet = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Date getDataNastere() {
        return dataNastere;
    }

    public String getClasa() {
        return clasa;
    }

    public String getScoala() {
        return scoala;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setDataNastere(Date dataNastere) {
        this.dataNastere = dataNastere;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public void setScoala(String scoala) {
        this.scoala = scoala;
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
