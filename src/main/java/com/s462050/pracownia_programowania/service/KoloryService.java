package com.s462050.pracownia_programowania.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462050.pracownia_programowania.model.Kolory;

import java.util.List;
import java.util.Optional;

public interface KoloryService {
    List<Kolory> findAll(); //Zwraca wszystkie obiekty

    Optional<Kolory> findById(Long id);

    Kolory save(Kolory kolory);

    Kolory update(Long id, Kolory kolory);

    void delete(Long id);

    String exportdata() throws JsonProcessingException;

    void importdata(String data) throws JsonProcessingException;
}
