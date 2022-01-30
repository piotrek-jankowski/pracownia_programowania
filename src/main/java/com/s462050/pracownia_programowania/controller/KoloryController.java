package com.s462050.pracownia_programowania.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462050.pracownia_programowania.model.Kolory;
import com.s462050.pracownia_programowania.service.KoloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kolory") //get, post; delete, update po "/" ID
public class KoloryController {
    private final KoloryService koloryService;
    @Autowired
    public KoloryController(KoloryService koloryService) {
        this.koloryService = koloryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Kolory>> findAll() {
        List<Kolory> allKolory = this.koloryService.findAll();
        return ResponseEntity.ok()
                .body(allKolory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kolory> findKolor(@PathVariable("id") Long id) {
        Optional<Kolory> kolor = this.koloryService.findById(id);
        if (kolor.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok()
                .body(kolor.get());
    }

    @PostMapping("/")
    public ResponseEntity<Kolory> addKolor(@RequestBody Kolory kolor) {
        return new ResponseEntity<>(koloryService.save(kolor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kolory> deleteKolor(@PathVariable("id") Long id) {
        Optional<Kolory> kolory = this.koloryService.findById(id);
        if (kolory.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        this.koloryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kolory> updateKolor(@PathVariable("id") Long id, @RequestBody Kolory kolor) {
        Optional<Kolory> istkolor = koloryService.findById(id);
        if (istkolor.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Kolory updatedKolor = this.koloryService.update(id, kolor);
        return new ResponseEntity<>(updatedKolor, HttpStatus.OK);
    }
}