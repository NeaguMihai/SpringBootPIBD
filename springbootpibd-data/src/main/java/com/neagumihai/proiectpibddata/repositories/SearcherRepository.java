package com.neagumihai.proiectpibddata.repositories;


import org.springframework.stereotype.Repository;

import java.util.List;

public interface SearcherRepository<S>{

    List<S> getFiltering(S model);

}
