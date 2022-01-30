package com.s462050.pracownia_programowania.service.impl;

import com.s462050.pracownia_programowania.model.TypLakieru;
import com.s462050.pracownia_programowania.repository.TypLakieruRepository;
import com.s462050.pracownia_programowania.service.TypLakieruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypLakieruServiceImpl implements TypLakieruService {
    private final TypLakieruRepository typLakieruRepository;
    @Autowired
    public TypLakieruServiceImpl(TypLakieruRepository typLakieruRepository) {
        this.typLakieruRepository = typLakieruRepository;
    }

    @Override
    public List<TypLakieru> findAll() {
        return typLakieruRepository.findAll();
    }

    @Override
    public Optional<TypLakieru> findById(Long id) {
        return typLakieruRepository.findById(id);
    }

    @Override
    public TypLakieru save(TypLakieru typLakieru) {

        return typLakieruRepository.save(typLakieru);
    }

    @Override
    public TypLakieru update(Long id, TypLakieru typLakieru) {
        return null;
    }

    @Override
    public void delete(Long id) {
        typLakieruRepository.deleteById(id);
    }
}
