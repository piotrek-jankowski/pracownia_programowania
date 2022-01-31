package com.s462050.pracownia_programowania.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s462050.pracownia_programowania.model.Samochod;
import com.s462050.pracownia_programowania.model.Samochod;
import com.s462050.pracownia_programowania.repository.SamochodRepository;
import com.s462050.pracownia_programowania.service.SamochodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SamochodServiceImpl implements SamochodService {
    private final SamochodRepository samochodRepository;
    @Autowired
    public SamochodServiceImpl(SamochodRepository samochodRepository) {
        this.samochodRepository = samochodRepository;
    }

    @Override
    public List<Samochod> findAll() {
        return samochodRepository.findAll();
    }

    @Override
    public Optional<Samochod> findById(Long id) {
        return samochodRepository.findById(id);
    }

    @Override
    public Samochod save(Samochod samochod) {

        return samochodRepository.save(samochod);
    }

    @Override
    public Samochod update(Long id, Samochod samochod) {
        return samochodRepository.save(samochod);
    }

    @Override
    public void delete(Long id) {
        samochodRepository.deleteById(id);
    }

    @Override
    public String exportdata() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Samochod> samochod = samochodRepository.findAll();
        return objectMapper.writeValueAsString(samochod);
    }

    @Override
    public void importdata(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Samochod> samochod = objectMapper.readValue(data, new TypeReference<List<Samochod>>() {});
        for(Samochod Samochod1: samochod){
            samochodRepository.save(Samochod1);
        }
    }
}
