package com.neagumihai.proiectpibddata.service;


import com.neagumihai.proiectpibddata.model.Tema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface TemaService {

    boolean saveTema(Tema tema);

    Page<Tema> getAll(Pageable pageable);

    List<Tema> getBySelects(Tema tema);

    void deleteById(Integer id);

    Tema updateById(Integer id, Tema tema);

    Optional<Tema> getById(Integer id);

    Page<Tema> getAllByConstraints(Pageable pageable, List<Integer> ids);

}
