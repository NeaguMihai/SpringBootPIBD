package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ElevService {

    boolean saveElev(Elev elev);

    Set<Elev> getAll(Integer hLimit, Integer lLimit);

    List<Elev> getBySelects(Elev elev);

    void deleteById(Integer id);

    Elev updateById(Integer id, Elev elev);

}
