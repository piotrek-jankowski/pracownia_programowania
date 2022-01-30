package com.s462050.pracownia_programowania.service;

import com.s462050.pracownia_programowania.model.TypLakieru;

import java.util.List;
import java.util.Optional;

public interface TypLakieruService {
    List<TypLakieru> findAll(); //Zwraca wszystkie obiekty

    Optional<TypLakieru> findById(Long id);

    TypLakieru save(TypLakieru typLakieru);

    TypLakieru update(Long id, TypLakieru typLakieru);

    void delete(Long id);
}
