package com.s462050.pracownia_programowania.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462050.pracownia_programowania.model.Samochod;
import com.s462050.pracownia_programowania.model.Samochod;
import com.s462050.pracownia_programowania.service.SamochodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/samochod") //get, post; delete, update po "/" ID
public class SamochodController {
    private final SamochodService samochodService;
    @Autowired
    public SamochodController(SamochodService samochodService) {
        this.samochodService = samochodService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Samochod>> findAll() {
        List<Samochod> allSamochod = this.samochodService.findAll();
        return ResponseEntity.ok()
                .body(allSamochod);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Samochod> findSamochod1(@PathVariable("id") Long id) {
        Optional<Samochod> samochod1 = this.samochodService.findById(id);
        if (samochod1.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok()
                .body(samochod1.get());
    }

    @PostMapping("/")
    public ResponseEntity<Samochod> addSamochod1(@RequestBody Samochod samochod1) {
        return new ResponseEntity<>(samochodService.save(samochod1), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Samochod> deleteSamochod1(@PathVariable("id") Long id) {
        Optional<Samochod> samochod = this.samochodService.findById(id);
        if (samochod.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        this.samochodService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Samochod> updateSamochod1(@PathVariable("id") Long id, @RequestBody Samochod samochod1) {
        Optional<Samochod> istsamochod1 = samochodService.findById(id);
        if (istsamochod1.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Samochod updatedSamochod1 = this.samochodService.update(id, samochod1);
        return new ResponseEntity<>(updatedSamochod1, HttpStatus.OK);
    }

    @GetMapping("/export")
    public ResponseEntity<String> exportData() throws JsonProcessingException {
        String data = samochodService.exportdata();
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestBody String data) throws JsonProcessingException {
        samochodService.importdata(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}