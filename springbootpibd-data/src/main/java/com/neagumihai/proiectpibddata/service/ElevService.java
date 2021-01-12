package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.model.Tema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface ElevService {

    boolean saveElev(Elev elev);

    Page<Elev> getAll(Pageable pageable);

    List<Elev> getBySelects(Elev elev);

    void deleteById(Integer id);

    Elev updateById(Integer id, Elev elev);

    Optional<Elev> getById(Integer id);


}
