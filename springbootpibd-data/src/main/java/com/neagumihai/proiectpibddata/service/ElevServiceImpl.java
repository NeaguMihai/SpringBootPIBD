package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.repositories.ElevRepository;
import com.neagumihai.proiectpibddata.repositories.SearcherRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ElevServiceImpl implements ElevService{

    private final ElevRepository elevRepository;

    @Qualifier("ElevSearcherRepository")
    private final SearcherRepository<Elev> searcherRepository;

    public ElevServiceImpl(ElevRepository elevRepository, SearcherRepository searcherRepository) {
        this.elevRepository = elevRepository;
        this.searcherRepository = searcherRepository;
    }

    @Override
    public boolean saveElev(Elev elev) {
        if (getBySelects(elev).size() == 0) {
            elevRepository.save(elev);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Set<Elev> getAll(Integer hLimit, Integer lLimit) {
        return null;
    }

    @Override
    public List<Elev> getBySelects(Elev elev) {
        return searcherRepository.getBySelects(elev);
    }

    @Override
    public void deleteById(Integer id) {

        elevRepository.deleteById(id);
    }

    @Override
    public Elev updateById(Integer id, Elev elev) {

        elev.setId(id);

        return elevRepository.save(elev);
    }
}
