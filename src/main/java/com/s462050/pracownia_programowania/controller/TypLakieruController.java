package com.s462050.pracownia_programowania.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462050.pracownia_programowania.model.TypLakieru;
import com.s462050.pracownia_programowania.model.TypLakieru;
import com.s462050.pracownia_programowania.service.TypLakieruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/typLakieru") //get, post; delete, update po "/" ID
public class TypLakieruController {
    private final TypLakieruService typLakieruService;
    @Autowired
    public TypLakieruController(TypLakieruService typLakieruService) {
        this.typLakieruService = typLakieruService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TypLakieru>> findAll() {
        List<TypLakieru> allTypLakieru = this.typLakieruService.findAll();
        return ResponseEntity.ok()
                .body(allTypLakieru);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypLakieru> findTypLakier(@PathVariable("id") Long id) {
        Optional<TypLakieru> typLakier = this.typLakieruService.findById(id);
        if (typLakier.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok()
                .body(typLakier.get());
    }

    @PostMapping("/")
    public ResponseEntity<TypLakieru> addTypLakier(@RequestBody TypLakieru typLakier) {
        return new ResponseEntity<>(typLakieruService.save(typLakier), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypLakieru> deleteTypLakier(@PathVariable("id") Long id) {
        Optional<TypLakieru> typLakieru = this.typLakieruService.findById(id);
        if (typLakieru.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        this.typLakieruService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypLakieru> updateTypLakier(@PathVariable("id") Long id, @RequestBody TypLakieru typLakier) {
        Optional<TypLakieru> isttypLakier = typLakieruService.findById(id);
        if (isttypLakier.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        TypLakieru updatedTypLakier = this.typLakieruService.update(id, typLakier);
        return new ResponseEntity<>(updatedTypLakier, HttpStatus.OK);
    }

    @GetMapping("/export")
    public ResponseEntity<String> exportData() throws JsonProcessingException {
        String data = typLakieruService.exportdata();
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestBody String data) throws JsonProcessingException {
        typLakieruService.importdata(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}