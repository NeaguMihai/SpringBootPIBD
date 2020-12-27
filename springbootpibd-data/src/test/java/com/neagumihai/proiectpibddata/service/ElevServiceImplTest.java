package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.repositories.ElevRepository;
import com.neagumihai.proiectpibddata.repositories.ElevSearcherRepository;
import com.neagumihai.proiectpibddata.repositories.ElevSearcherRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ElevServiceImplTest {

    Elev returned;

    @Mock
    ElevRepository elevRepository ;

    @Mock
    ElevSearcherRepository searcherRepository;


    @InjectMocks
    ElevService elevService  = new ElevServiceImpl(elevRepository,searcherRepository);

    @BeforeEach
    void setUp() {
        elevService =  new ElevServiceImpl(elevRepository,searcherRepository);
        returned = new Elev();
        returned.setNume("test1");
        returned.setPrenume("test2");
    }

    @Test
    void saveElevTest() {
        when(elevRepository.save(any())).thenReturn(returned);
        when(searcherRepository.getFiltering(returned)).thenReturn(Collections.emptyList()).thenReturn(Collections.singletonList(returned));
        boolean b = elevService.saveElev(returned);
        boolean c = elevService.saveElev(returned);

        assertNotEquals(b,c);

        verify(elevRepository).save(any());
    }

    @Test
    void getall() {
        List<Elev> li = new LinkedList<>();
        for(int i =0; i<50; i++) {
            returned.setId(i);
            li.add(returned);
        }
        when(elevRepository.getAllByLimit(any(), any())).thenReturn(li);

        int g = elevService.getAll(1,1).size();

        assertEquals(g, 50);
    }
}