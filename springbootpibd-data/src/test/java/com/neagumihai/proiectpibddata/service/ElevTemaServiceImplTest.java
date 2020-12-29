package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.repositories.ElevRepository;
import com.neagumihai.proiectpibddata.repositories.ElevTemaRepository;
import com.neagumihai.proiectpibddata.repositories.TemaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ElevTemaServiceImplTest {

    ElevTema returned;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ElevTemaRepository elevTemaRepository;

    @Autowired
    private ElevRepository elevRepository;

    @Autowired
    private TemaRepository temaRepository;

    private ElevTemaService elevTemaService;

    @BeforeEach
    void setUp() {
        elevTemaService = new ElevTemaServiceImpl(elevTemaRepository, elevRepository, temaRepository);
        returned = new ElevTema();
        Elev e1 = new Elev();
        e1.setId(1);
        entityManager.merge(e1);

        Tema t1 = new Tema();
        t1.setId(1);
        entityManager.merge(t1);

        returned.setTema(t1);
        returned.setElev(e1);
    }

    @Test
    void saveTest() {

        boolean b = elevTemaService.saveTema(returned);
        boolean c = elevTemaService.saveTema(returned);

        assertNotEquals(b,c);

        Elev e1 = elevRepository.getOne(1);
        Tema t1 = temaRepository.getOne(1);

        assertEquals(e1.getElevTemaSet().size(),1);
        assertEquals(t1.getElevTemaSet().size(),1);
        assertEquals(returned, e1.getElevTemaSet().iterator().next());
        assertEquals(returned, t1.getElevTemaSet().iterator().next());
        assertEquals(e1.getElevTemaSet().iterator().next(),t1.getElevTemaSet().iterator().next());

    }

    @Test
    void deleteElevTemaTest() {
        elevTemaService.saveTema(returned);
        elevTemaService.deleteElevTema(returned);

        Elev e1 = elevRepository.getAllByLimit(0,100).get(0);
        Tema t1 = temaRepository.getAllByLimit(0,100).get(0);

        assertEquals(e1.getElevTemaSet().size(),0);
        assertEquals(t1.getElevTemaSet().size(),0);

    }

    @Test
    void deleteElevTest() {
        elevTemaService.saveTema(returned);

        Tema t1 = temaRepository.getAllByLimit(0,100).get(0);

        assertFalse(entityManager.contains(returned));
        assertTrue(entityManager.contains(t1));

    }


    void updateTest() {
        elevTemaService.saveTema(returned);

        returned.setLink_tema("ssssss");

        elevTemaService.updateElevTema(returned);


        Elev e1 = elevRepository.getAllByLimit(0,100).get(0);
        Tema t1 = temaRepository.getAllByLimit(0,100).get(0);

        assertEquals(returned.getLink_tema(), e1.getElevTemaSet().iterator().next().getLink_tema());
        assertEquals(returned.getLink_tema(), t1.getElevTemaSet().iterator().next().getLink_tema());
    }
}