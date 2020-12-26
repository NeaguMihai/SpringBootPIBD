package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.Elev;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ElevSearcherRepository implements SearcherRepository<Elev>{


    private final EntityManager em;

    public ElevSearcherRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Elev> getBySelects(Elev model) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Elev> cq = cb.createQuery(Elev.class);

        Root<Elev> elev = cq.from(Elev.class);

        List<Predicate> predicates = new ArrayList<>();

        if(model.getClasa() != null) {
            predicates.add(cb.equal(elev.get("clasa"), model.getClasa()));
        }
        if(model.getDataNastere() != null) {
            predicates.add(cb.equal(elev.get("data_nastere"), model.getDataNastere()));
        }
        if(model.getNume() != null) {
            predicates.add(cb.equal(elev.get("nume"), model.getNume()));
        }
        if(model.getPrenume() != null) {
            predicates.add(cb.equal(elev.get("prenume"), model.getPrenume()));
        }
        if (model.getScoala() != null) {
            predicates.add(cb.equal(elev.get("scoala"), model.getScoala()));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }
}
