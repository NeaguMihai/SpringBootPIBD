package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.Tema;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TemaSearcherRepositoryImpl implements SearcherRepository<Tema> {

    private final EntityManager em;

    public TemaSearcherRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Tema> getFiltering(Tema model) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tema> cq = cb.createQuery(Tema.class);

        Root<Tema> elev = cq.from(Tema.class);

        List<Predicate> predicates = new ArrayList<>();

        if(model.getCerintaTema() != null) {
            predicates.add(cb.equal(elev.get("cerintaTema"), model.getCerintaTema()));
        }
        if(model.getNumarTema() != null) {
            predicates.add(cb.equal(elev.get("numarTema"), model.getNumarTema()));
        }
        if(model.getNumeTema() != null) {
            predicates.add(cb.equal(elev.get("numeTema"), model.getNumeTema()));
        }
        if(model.getDificultate() != null) {
            predicates.add(cb.equal(elev.get("dificiltate"), model.getDificultate()));
        }
        if (model.getPuncte() != null) {
            predicates.add(cb.equal(elev.get("puncte"), model.getPuncte()));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

}
