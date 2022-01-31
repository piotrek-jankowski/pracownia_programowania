package com.s462050.pracownia_programowania.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462050.pracownia_programowania.model.Samochod;

import java.util.List;
import java.util.Optional;

public interface SamochodService {
    List<Samochod> findAll(); //Zwraca wszystkie obiekty

    Optional<Samochod> findById(Long id);

    Samochod save(Samochod samochod);

    Samochod update(Long id, Samochod samochod);

    void delete(Long id);

    String exportdata() throws JsonProcessingException;

    void importdata(String data) throws JsonProcessingException;
}
