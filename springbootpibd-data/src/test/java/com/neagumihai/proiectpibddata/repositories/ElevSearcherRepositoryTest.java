package com.neagumihai.proiectpibddata.repositories;


import com.neagumihai.proiectpibddata.model.Elev;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ElevSearcherRepositoryTest{

    @Autowired
    private EntityManager testEntityManager;


    private ElevSearcherRepositoryImpl elevSearcherRepository;

    @BeforeEach
    void setup() {
        elevSearcherRepository = new ElevSearcherRepositoryImpl(testEntityManager);
        Elev e1 = new Elev();
        e1.setNume("mih");
        e1.setPrenume("nah");
        e1.setScoala("sc1");
        e1.setClasa("XII");
        e1.setPuncte(22);

        Elev e2 = new Elev();
        e2.setNume("mih");
        e2.setPrenume("hah");
        e2.setScoala("sc2");
        e2.setClasa("XI");
        e2.setPuncte(33);
        testEntityManager.persist(e1);
        testEntityManager.persist(e2);
        testEntityManager.flush();
    }

    @Test
    void returnAfterOneCryt() {
        Elev e1 = new Elev();
        e1.setNume("mih");

        List<Elev> returned = elevSearcherRepository.getFiltering(e1);

        Assertions.assertEquals(returned.size(),2);

    }

    @Test
    void returnAfterMultipleCryt() {
        Elev e1 = new Elev();
        e1.setPuncte(22);
        e1.setPrenume("nah");

        List<Elev> returned = elevSearcherRepository.getFiltering(e1);

        Assertions.assertEquals(returned.size(),1);

    }


}