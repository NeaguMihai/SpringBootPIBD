package com.neagumihai.proiectpibddata.repositories;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearcherRepository<S>{

    List<S> getFiltering(S model);

}
