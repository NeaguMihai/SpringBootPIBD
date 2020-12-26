package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.ElevTemaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevTemaRepository extends JpaRepository<ElevTema, ElevTemaId> {
}
