package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.repositories.SearcherRepository;
import com.neagumihai.proiectpibddata.repositories.TemaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaServiceImpl implements TemaService{

    private final TemaRepository temaRepository;

    @Qualifier("TemaSearcherRepository")
    private final SearcherRepository<Tema> searcherRepository;

    public TemaServiceImpl(TemaRepository temaRepository, SearcherRepository<Tema> searcherRepository) {
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
        return searcherRepository.getBySelects(tema);
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
