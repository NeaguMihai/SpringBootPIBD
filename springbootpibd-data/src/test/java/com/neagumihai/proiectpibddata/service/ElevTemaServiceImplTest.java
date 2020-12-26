package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.repositories.ElevTemaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ElevTemaServiceImplTest {

    ElevTema returned;

    @Mock
    ElevTemaRepository elevTemaRepository;

    @InjectMocks
    ElevTemaService elevTemaService = new ElevTemaServiceImpl(elevTemaRepository);

    @BeforeEach
    void setUp() {
        elevTemaService = new ElevTemaServiceImpl(elevTemaRepository);

        returned = new ElevTema();
    }

    @Test
    void saveTest() {
        when(elevTemaRepository.save(any())).thenReturn(returned);
        when(elevTemaRepository.findAllByIdElevAndIdTema(any(), any())).thenReturn(Optional.empty()).thenReturn(Optional.of(returned));

        boolean b = elevTemaService.saveTema(returned);
        boolean c = elevTemaService.saveTema(returned);

        assertNotEquals(b,c);

        verify(elevTemaRepository).save(any());
    }
}