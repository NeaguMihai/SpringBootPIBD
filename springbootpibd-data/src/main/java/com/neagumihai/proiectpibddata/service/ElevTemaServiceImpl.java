package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.repositories.ElevRepository;
import com.neagumihai.proiectpibddata.repositories.ElevTemaRepository;
import com.neagumihai.proiectpibddata.repositories.TemaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

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

    @Transactional
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

    @Transactional
    @Override
    public Page<ElevTema> getAll(Pageable pageable) {

        return elevTemaRepository.getAll(pageable);
    }

    @Transactional
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

    @Transactional
    @Override
    public ElevTema updateElevTema(ElevTema elevTema) {
        if (elevTemaRepository.update(elevTema.getLink_tema(), elevTema.getIdElev(), elevTema.getIdTema())==1)
            return elevTema;
        return new ElevTema();
    }

    @Transactional
    @Override
    public List<ElevTema> getByIdElev(Integer id) {
        return elevTemaRepository.findByIdElev(id);
    }

    @Transactional
    @Override
    public List<ElevTema> getByIdTema(Integer id) {
        return elevTemaRepository.findByIdTema(id);
    }

    @Transactional
    @Override
    public List<Integer> getAllIdsTeme(Integer id) {
        return elevTemaRepository.getAllIdTeme(id);
    }

    @Transactional
    @Override
    public Optional<ElevTema> findByIdElevAndIdTema(Integer idElev, Integer idTema) {
        return elevTemaRepository.findAllByIdElevAndIdTema(idElev, idTema);
    }

    @Transactional
    @Override
    public Map<Elev, List<Tema>> JoinSelect() {
        List<Object[]> resultSet = elevTemaRepository.joinSelect();

        Map<Elev, List<Tema>> returner = new HashMap<>();
        resultSet.forEach(e -> {
            Elev elev =  new Elev();
            elev.setNume(e[0].toString());
            elev.setPrenume(e[1].toString());
            elev.setClasa(e[2].toString());
            elev.setScoala(e[3].toString());
            String[] tok = e[4].toString().split(" ");

            List<Tema> teme = Arrays.stream(tok).map(s -> {
                Tema t = new Tema();
                t.setNumeTema(s);
                return t;
            }).collect(Collectors.toList());

            returner.put(elev, teme);
        });

        return returner;
    }
}
