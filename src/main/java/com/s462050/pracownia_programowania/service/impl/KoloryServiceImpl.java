package com.s462050.pracownia_programowania.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        return koloryRepository.findById(id);
    }

    @Override
    public Kolory save(Kolory kolory) {

        return koloryRepository.save(kolory);
    }

    @Override
    public Kolory update(Long id, Kolory kolory) {

        return koloryRepository.save(kolory);
    }

    @Override
    public void delete(Long id) {
        koloryRepository.deleteById(id);
    }

    @Override
    public String exportdata() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Kolory> kolory = koloryRepository.findAll();
        return objectMapper.writeValueAsString(kolory);
    }

    @Override
    public void importdata(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Kolory> kolory = objectMapper.readValue(data, new TypeReference<List<Kolory>>() {});
        for(Kolory kolor: kolory){
            koloryRepository.save(kolor);
        }
    }
}
