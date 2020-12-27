package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.repositories.ElevRepository;
import com.neagumihai.proiectpibddata.repositories.ElevTemaRepository;
import com.neagumihai.proiectpibddata.repositories.TemaRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class ElevTemaServiceImpl implements ElevTemaService {

    private final ElevTemaRepository elevTemaRepository;

    private final ElevRepository elevRepository;

    private final TemaRepository temaRepository;

    public ElevTemaServiceImpl(ElevTemaRepository elevTemaRepository, ElevRepository elevRepository, TemaRepository temaRepository) {
        this.elevTemaRepository = elevTemaRepository;
        this.elevRepository = elevRepository;
        this.temaRepository = temaRepository;
    }

    @Override
    public boolean saveTema(ElevTema elevTema) {

        Optional<Tema> returnedTema = temaRepository.findById(elevTema.getIdTema());
        Optional<Elev> returnedElev = elevRepository.findById(elevTema.getIdElev());

        if(returnedElev.isEmpty() || returnedTema.isEmpty()) {
            return false;
        }else if(elevTemaRepository
                .findAllByIdElevAndIdTema(returnedElev.get().getId(),
                        returnedTema.get().getId())
                .isPresent()) {
            return false;
        }else {
            returnedElev.get().getElevTemaSet().add(elevTema);
            returnedTema.get().getElevTemaSet().add(elevTema);
            elevRepository.save(returnedElev.get());
            temaRepository.save(returnedTema.get());
            elevTemaRepository.save(elevTema);
            return true;
        }
    }

    @Override
    public List<ElevTema> getAll(Integer offset, Integer limit) {

        return elevTemaRepository.getAll(offset, limit);
    }

    @Override
    public void deleteElevTema(ElevTema elevTema) {

        Optional<Elev> returnedElev = elevRepository.findById(elevTema.getIdElev());
        Optional<Tema> returnedTema = temaRepository.findById(elevTema.getIdTema());

        if(returnedElev.isPresent() && returnedTema.isPresent()) {
            returnedTema.get().getElevTemaSet().remove(elevTema);
            returnedElev.get().getElevTemaSet().remove(elevTema);
            elevTemaRepository.delete(elevTema);
        }
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
