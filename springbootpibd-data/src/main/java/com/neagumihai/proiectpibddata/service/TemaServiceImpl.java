package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.repositories.TemaRepository;
import com.neagumihai.proiectpibddata.repositories.TemaSearcherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaServiceImpl implements TemaService{

    private final TemaRepository temaRepository;

    private final TemaSearcherRepository searcherRepository;

    public TemaServiceImpl(TemaRepository temaRepository, TemaSearcherRepository searcherRepository) {
        this.temaRepository = temaRepository;
        this.searcherRepository = searcherRepository;
    }

    @Override
    public boolean saveTema(Tema tema) {
        Tema searchTema = new Tema();
        searchTema.setNumarTema(tema.getNumarTema());
        searchTema.setNumeTema(tema.getNumeTema());
        searchTema.setNumeCulegere(tema.getNumeCulegere());

        if (getBySelects(searchTema).size() == 0) {
            temaRepository.save(tema);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Tema> getAll(Integer offset, Integer limit) {
        return temaRepository.getAllByLimit(offset, limit);
    }

    @Override
    public List<Tema> getBySelects(Tema tema) {
        return searcherRepository.getFiltering(tema);
    }

    @Override
    public void deleteById(Integer id) {
        temaRepository.deleteById(id);
    }

    @Override
    public Tema updateById(Integer id, Tema tema) {

        tema.setId(id);

        return temaRepository.save(tema);
    }
}
