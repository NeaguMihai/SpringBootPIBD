package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.Elev;
import org.springframework.data.repository.Repository;

public interface ElevSearcherRepository extends Repository<Elev, Integer>, SearcherRepository<Elev> {
}
