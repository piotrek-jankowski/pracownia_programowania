package com.s462050.pracownia_programowania.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s462050.pracownia_programowania.model.Kierowcy;
import com.s462050.pracownia_programowania.model.Kierowcy;
import com.s462050.pracownia_programowania.repository.KierowcyRepository;
import com.s462050.pracownia_programowania.service.KierowcyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KierowcyServiceImpl implements KierowcyService {
    private final KierowcyRepository kierowcyRepository;
    @Autowired
    public KierowcyServiceImpl(KierowcyRepository kierowcyRepository) {
        this.kierowcyRepository = kierowcyRepository;
    }

    @Override
    public List<Kierowcy> findAll() {
        return kierowcyRepository.findAll();
    }

    @Override
    public Optional<Kierowcy> findById(Long id) {
        return kierowcyRepository.findById(id);
    }

    @Override
    public Kierowcy save(Kierowcy kierowcy) {

        return kierowcyRepository.save(kierowcy);
    }

    @Override
    public Kierowcy update(Long id, Kierowcy kierowcy) {
        return kierowcyRepository.save(kierowcy);
    }

    @Override
    public void delete(Long id) {
        kierowcyRepository.deleteById(id);
    }


    @Override
    public String exportdata() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Kierowcy> kierowcy = kierowcyRepository.findAll();
        return objectMapper.writeValueAsString(kierowcy);
    }

    @Override
    public void importdata(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Kierowcy> kierowcy = objectMapper.readValue(data, new TypeReference<List<Kierowcy>>() {});
        for(Kierowcy kierowca: kierowcy){
            kierowcyRepository.save(kierowca);
        }
    }
}