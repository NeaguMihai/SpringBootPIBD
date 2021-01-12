package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.Tema;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository("temaSearcherRepository")
@Qualifier("temaSearcherRepository")
public class TemaSearcherRepositoryImpl implements TemaSearcherRepository {

    private final EntityManager em;

    public TemaSearcherRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Tema> getFiltering(Tema model) {
        StringBuilder sb = new StringBuilder();
        String initial = "SELECT t FROM Tema t WHERE ";
        sb.append(initial);
        Map<String, Object> params = new HashMap<>();

        if(model.getCerintaTema() != null) {
            sb.append("t.cerintaTema = : cerT");
            params.put("cerT", model.getCerintaTema());

        }
        if(model.getNumarTema() != null) {
            if(!params.isEmpty())
                sb.append(" AND ");
            sb.append(" t.numarTema = :numT");
            params.put("numT", model.getNumarTema());
        }
        if(model.getNumeCulegere() != null) {
            if(!params.isEmpty())
                sb.append(" AND ");
            sb.append(" t.numeCulegere = : numC");
            params.put("numC", model.getNumeCulegere());
        }
        if(model.getNumeTema() != null) {
            if(!params.isEmpty())
                sb.append(" AND ");
            sb.append(" t.numeTema = : numeT");
            params.put("numeT", model.getNumeTema());
        }
        if(model.getDificultate() != null) {
            if(!params.isEmpty())
                sb.append(" AND ");
            sb.append(" t.dificultate = : dif");
            params.put("dif", model.getDificultate());
        }
        if (model.getPuncte() != null) {
            if(!params.isEmpty())
                sb.append(" AND ");
            sb.append(" t.puncte = : pct");
            params.put("pct", model.getPuncte());
        }
        if(sb.toString().equalsIgnoreCase(initial)) {
            return Collections.emptyList();
        }
        TypedQuery<Tema> query = em.createQuery(sb.toString(), Tema.class);
        params.forEach(query::setParameter);
        return query.getResultList();
    }

}
