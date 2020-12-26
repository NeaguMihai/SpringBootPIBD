package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.model.Tema;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TemaSearcherRepository implements SearcherRepository<Tema>{

    private final EntityManager em;

    public TemaSearcherRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Tema> getBySelects(Tema model) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tema> cq = cb.createQuery(Tema.class);

        Root<Tema> elev = cq.from(Tema.class);

        List<Predicate> predicates = new ArrayList<>();

        if(model.getCerintaTema() != null) {
            predicates.add(cb.equal(elev.get("cerinta_tema"), model.getCerintaTema()));
        }
        if(model.getNumarTema() != null) {
            predicates.add(cb.equal(elev.get("numar_tema"), model.getNumarTema()));
        }
        if(model.getNumeTema() != null) {
            predicates.add(cb.equal(elev.get("nume_tema"), model.getNumeTema()));
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
