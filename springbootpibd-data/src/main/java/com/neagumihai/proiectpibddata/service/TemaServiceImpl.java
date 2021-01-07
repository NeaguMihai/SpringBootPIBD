package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.repositories.TemaRepository;
import com.neagumihai.proiectpibddata.repositories.TemaSearcherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TemaServiceImpl implements TemaService{

    private final TemaRepository temaRepository;

    private final ElevTemaService elevTemaService;

    private final TemaSearcherRepository searcherRepository;

    public TemaServiceImpl(TemaRepository temaRepository, ElevTemaService elevTemaService, TemaSearcherRepository searcherRepository) {
        this.temaRepository = temaRepository;
        this.elevTemaService = elevTemaService;
        this.searcherRepository = searcherRepository;
    }

    @Override
    public boolean saveTema(Tema tema) {
        Tema searchTema = new Tema();
        searchTema.setNumarTema(tema.getNumarTema());
        searchTema.setNumeCulegere(tema.getNumeCulegere());

        if (getBySelects(searchTema).size() == 0) {
            temaRepository.save(tema);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Page<Tema> getAll(Pageable pageable) {
        return temaRepository.getAllByLimit(pageable);
    }

    @Override
    public List<Tema> getBySelects(Tema tema) {
        return searcherRepository.getFiltering(tema);
    }

    @Override
    public void deleteById(Integer id) {

        elevTemaService.getByIdTema(id).forEach(elevTemaService::deleteElevTema);

        temaRepository.deleteById(id);
    }

    @Override
    public Tema updateById(Integer id, Tema tema) {

        tema.setId(id);

        return temaRepository.save(tema);
    }

    @Override
    public Optional<Tema> getById(Integer id) {
        return temaRepository.findById(id);
    }

    @Override
    public Page<Tema> getAllByConstraints(Pageable pageable, List<Integer> ids) {
        return temaRepository.getAllByLimitAndId( ids, pageable);
    }
}
