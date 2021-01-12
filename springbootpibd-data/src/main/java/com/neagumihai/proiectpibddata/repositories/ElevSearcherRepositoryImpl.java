package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.Elev;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository
public class ElevSearcherRepositoryImpl implements ElevSearcherRepository {

    private final EntityManager em;

    public ElevSearcherRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Elev> getFiltering(Elev model) {
        StringBuilder sb = new StringBuilder();
        String initial = "SELECT e FROM Elev e WHERE ";
        sb.append(initial);
        Map<String, Object> params = new HashMap<>();

        if(model.getClasa() != null) {
            sb.append("e.clasa =: class");
            params.put("class", model.getClasa());
        }
        if(model.getDataNastere() != null) {
            if(!params.isEmpty()) {
                sb.append(" AND ");
            }
            sb.append("e.dataNastere =: dn");
            params.put("dn", model.getDataNastere());
        }
        if(model.getNume() != null) {
            if(!params.isEmpty()) {
                sb.append(" AND ");
            }
            sb.append("e.nume =: num");
            params.put("num", model.getNume());
        }
        if(model.getPrenume() != null) {
            if(!params.isEmpty()) {
                sb.append(" AND ");
            }
            sb.append("e.prenume =: pren");
            params.put("pren", model.getPrenume());
        }
        if (model.getScoala() != null) {
            if(!params.isEmpty()) {
                sb.append(" AND ");
            }
            sb.append("e.scoala =: scl");
            params.put("scl", model.getScoala());
        }
        if(sb.toString().equalsIgnoreCase(initial)) {
            return new LinkedList<>();
        }
        TypedQuery<Elev> query = em.createQuery(sb.toString(), Elev.class);
        params.forEach(query::setParameter);
        return query.getResultList();
    }

}
