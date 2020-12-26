package com.neagumihai.proiectpibddata.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "elev")
public class Elev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "data_nastere")
    private Date dataNastere;

    @Column(name = "clasa")
    private String clasa;

    @Column(name = "scoala")
    private String scoala;

    @Column(name = "puncte")
    private Integer puncte;

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
}
