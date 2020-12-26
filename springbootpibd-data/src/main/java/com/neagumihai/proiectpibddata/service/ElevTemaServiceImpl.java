package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.repositories.ElevTemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElevTemaServiceImpl implements ElevTemaService {

    private final ElevTemaRepository elevTemaRepository;

    public ElevTemaServiceImpl(ElevTemaRepository elevTemaRepository) {
        this.elevTemaRepository = elevTemaRepository;
    }

    @Override
    public boolean saveTema(ElevTema elevTema) {

        if (elevTemaRepository.findAllByIdElevAndIdTema(elevTema.getIdElev(), elevTema.getIdTema()).isEmpty()) {

            elevTemaRepository.save(elevTema);

            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<ElevTema> getAll(Integer offset, Integer limit) {

        return elevTemaRepository.getAll(offset, limit);
    }

    @Override
    public void deleteElevTema(ElevTema elevTema) {

        elevTemaRepository.delete(elevTema);
    }

    @Override
    public ElevTema updateElevTema(ElevTema elevTema) {
        return elevTemaRepository.save(elevTema);
    }

    @Override
    public List<ElevTema> getByIdElev(Integer id) {
        return elevTemaRepository.findByIdElev(id);
    }
}
