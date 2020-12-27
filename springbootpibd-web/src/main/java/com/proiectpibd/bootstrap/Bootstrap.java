package com.proiectpibd.bootstrap;

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

        Tema t2 = new Tema();
        t2.setNumeTema("tema2");
        t2.setPuncte(22);

        temaService.saveTema(t1);
        temaService.saveTema(t2);

        ElevTema et1 = new ElevTema();
        et1.setElev(e1);
        et1.setTema(t1);

        elevTemaService.saveTema(et1);


    }
}
