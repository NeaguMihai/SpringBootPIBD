package com.neagumihai.proiectpibddata.service;


import com.neagumihai.proiectpibddata.model.Tema;

import java.util.List;

public interface TemaService {

    boolean saveTema(Tema tema);

    List<Tema> getAll(Integer offset, Integer limit);

    List<Tema> getBySelects(Tema tema);

    void deleteById(Integer id);

    Tema updateById(Integer id, Tema tema);

}
