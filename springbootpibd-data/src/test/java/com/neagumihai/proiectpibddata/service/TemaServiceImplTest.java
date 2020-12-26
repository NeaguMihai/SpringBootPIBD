package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.repositories.ElevRepository;
import com.neagumihai.proiectpibddata.repositories.SearcherRepository;
import com.neagumihai.proiectpibddata.repositories.TemaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TemaServiceImplTest {

    Tema returned;

    @Mock
    TemaRepository temaRepository ;

    @Mock
    SearcherRepository<Tema> searcherRepository;


    @InjectMocks
    TemaService temaService  = new TemaServiceImpl(temaRepository,searcherRepository);

    @BeforeEach
    void setUp() {
        temaService =  new TemaServiceImpl(temaRepository,searcherRepository);
        returned = new Tema();
        returned.setNumeTema("test1");
        returned.setNumeCulegere("test2");
    }

    @Test
    void saveElevTest() {
        when(temaRepository.save(any())).thenReturn(returned);
        when(searcherRepository.getBySelects(any())).thenReturn(Collections.emptyList()).thenReturn(Collections.singletonList(returned));
        boolean b = temaService.saveTema(returned);
        boolean c = temaService.saveTema(returned);

        assertNotEquals(b,c);

        verify(temaRepository).save(any());
    }

    @Test
    void getall() {
        List<Tema> li = new LinkedList<>();
        for(int i =0; i<50; i++) {
            returned.setId(i);
            li.add(returned);
        }
        when(temaRepository.getAllByLimit(any(), any())).thenReturn(li);

        int g = temaService.getAll(1,1).size();

        assertEquals(g, 50);
    }
}