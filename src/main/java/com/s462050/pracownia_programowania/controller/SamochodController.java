package com.s462050.pracownia_programowania.controller;

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
}