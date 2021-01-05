package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.repositories.ElevRepository;
import com.neagumihai.proiectpibddata.repositories.ElevSearcherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ElevServiceImpl implements ElevService{

    private final ElevRepository elevRepository;

    private final ElevTemaService elevTemaService;

    private final ElevSearcherRepository searcherRepository;

    public ElevServiceImpl(ElevRepository elevRepository, ElevTemaService elevTemaService, ElevSearcherRepository searcherRepository) {
        this.elevRepository = elevRepository;
        this.elevTemaService = elevTemaService;
        this.searcherRepository = searcherRepository;
    }

    @Transactional
    @Override
    public boolean saveElev(Elev elev) {
        if (getBySelects(elev).size() == 0) {
            elevRepository.save(elev);

            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public Page<Elev> getAll(Pageable pageable) {
        return elevRepository.getAllByLimit(pageable);
    }

    @Transactional
    @Override
    public List<Elev> getBySelects(Elev elev) {
        return searcherRepository.getFiltering(elev);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {

        elevTemaService.getByIdElev(id).forEach(elevTemaService::deleteElevTema);

        elevRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Elev updateById(Integer id, Elev elev) {

        elev.setId(id);

        return elevRepository.save(elev);
    }

    @Override
    public Optional<Elev> getById(Integer id) {
        return elevRepository.findById(id);
    }
}
