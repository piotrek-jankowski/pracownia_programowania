package com.s462050.pracownia_programowania.service.impl;

import com.s462050.pracownia_programowania.model.Kolory;
import com.s462050.pracownia_programowania.repository.KoloryRepository;
import com.s462050.pracownia_programowania.service.KoloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KoloryServiceImpl implements KoloryService {
    private final KoloryRepository koloryRepository;
    @Autowired
    public KoloryServiceImpl(KoloryRepository koloryRepository) {
        this.koloryRepository = koloryRepository;
    }

    @Override
    public List<Kolory> findAll() {
        return koloryRepository.findAll();
    }

    @Override
    public Optional<Kolory> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Kolory save(Kolory kolory) {
        return null;
    }

    @Override
    public Kolory update(Long id, Kolory kolory) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}