package com.proiectpibd.controllers;

import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.service.TemaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TemeController.class)
@AutoConfigureMockMvc
public class TemeControllerTest {

    List<Tema> temaList;

    @Mock
    TemaService temaService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        temaList = new ArrayList<>();
        Tema tema1 = new Tema();
        tema1.setId(1);
        tema1.setNumeTema("tema1");
        Tema tema2 = new Tema();
        tema2.setId(2);
        tema2.setNumeTema("tema2");

        temaList.add(tema1);
        temaList.add(tema2);

    }

    @Test
    void testControllerReturn() throws Exception {


        mockMvc.perform(get("/teme"))
                .andExpect(view().name("teme/index"));
    }
}