package com.proiectpibd.bootstrap;

import com.neagumihai.proiectpibddata.model.Dificultate;
import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.service.ElevService;
import com.neagumihai.proiectpibddata.service.ElevTemaService;
import com.neagumihai.proiectpibddata.service.TemaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
public class Bootstrap implements CommandLineRunner {

    private final ElevService elevService;

    private final TemaService temaService;

    private final ElevTemaService elevTemaService;

    private static final Logger log = LoggerFactory.getLogger(CommandLineRunner.class);

    public Bootstrap(ElevService elevService, TemaService temaService, ElevTemaService elevTemaService) {
        this.elevService = elevService;
        this.temaService = temaService;
        this.elevTemaService = elevTemaService;
    }


    @Override
    public void run(String... args) throws Exception {

        persistSomeData();
    }

    public void persistSomeData() {

        Elev e1  = new Elev();
        e1.setPrenume("pren1");
        e1.setNume("nume1");


        Elev e2  = new Elev();
        e2.setPrenume("pren2");
        e2.setNume("nume2");

        elevService.saveElev(e1);
        elevService.saveElev(e2);

        Tema t1 = new Tema();
        t1.setNumeTema("tema1");
        t1.setPuncte(11);
        t1.setNumeCulegere("cul1");
        t1.setCerintaTema("loren ipsul sum dolors");
        t1.setDificultate(Dificultate.Mediu);


        Tema t2 = new Tema();
        t2.setNumeTema("tema2");
        t2.setPuncte(22);
        t2.setNumeCulegere("cul2");
        t2.setCerintaTema("loren ipsul sum dolors");
        t2.setDificultate(Dificultate.Greu);


        Tema t3 = new Tema();
        t3.setNumeTema("tema3");
        t3.setNumeCulegere("cul3");
        t3.setPuncte(33);
        t3.setDificultate(Dificultate.Mediu);

        Tema t4 = new Tema();
        t4.setNumeTema("tema4");
        t4.setNumeCulegere("cul4");
        t4.setPuncte(44);

        Tema t5 = new Tema();
        t5.setNumeTema("tema5");
        t5.setNumeCulegere("cul5");
        t5.setPuncte(55);

        Tema t6 = new Tema();
        t6.setNumeTema("tema6");
        t6.setNumeCulegere("cul6");
        t6.setPuncte(66);

        temaService.saveTema(t1);
        temaService.saveTema(t2);
        temaService.saveTema(t3);
        temaService.saveTema(t4);
        temaService.saveTema(t5);
        temaService.saveTema(t6);

        ElevTema et1 = new ElevTema();
        et1.setElev(e1);
        et1.setTema(t1);

        elevTemaService.saveTema(et1);


    }
}
