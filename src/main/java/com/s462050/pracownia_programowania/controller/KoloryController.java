package com.s462050.pracownia_programowania.controller;

import com.s462050.pracownia_programowania.model.Kolory;
import com.s462050.pracownia_programowania.service.KoloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}


