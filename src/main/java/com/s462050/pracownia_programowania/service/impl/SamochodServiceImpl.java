package com.s462050.pracownia_programowania.service.impl;

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
        return null;
    }

    @Override
    public void delete(Long id) {
        samochodRepository.deleteById(id);
    }
}
