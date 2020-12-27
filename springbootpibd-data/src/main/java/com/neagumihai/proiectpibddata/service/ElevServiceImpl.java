package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.repositories.ElevRepository;
import com.neagumihai.proiectpibddata.repositories.ElevSearcherRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ElevServiceImpl implements ElevService{

    private final ElevRepository elevRepository;

    private final ElevSearcherRepository searcherRepository;

    public ElevServiceImpl(ElevRepository elevRepository, ElevSearcherRepository searcherRepository) {
        this.elevRepository = elevRepository;
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
    public List<Elev> getAll(Integer offset, Integer limit) {
        return elevRepository.getAllByLimit(offset, limit);
    }

    @Transactional
    @Override
    public List<Elev> getBySelects(Elev elev) {
        return searcherRepository.getFiltering(elev);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {

        elevRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Elev updateById(Integer id, Elev elev) {

        elev.setId(id);

        return elevRepository.save(elev);
    }
}
