package com.neagumihai.proiectpibddata.repositories;

import java.util.List;
public interface SearcherRepository<S> {

    List<S> getBySelects(S model);

}
