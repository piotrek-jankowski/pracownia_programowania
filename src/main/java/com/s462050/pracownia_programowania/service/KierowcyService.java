package com.s462050.pracownia_programowania.service;

import com.s462050.pracownia_programowania.model.Kierowcy;

import java.util.List;
import java.util.Optional;

public interface KierowcyService {
    List<Kierowcy> findAll(); //Zwraca wszystkie obiekty

    Optional<Kierowcy> findById(Long id);

    Kierowcy save(Kierowcy kierowcy);

    Kierowcy update(Long id, Kierowcy kierowcy);

    void delete(Long id);
}
