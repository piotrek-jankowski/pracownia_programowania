package com.s462050.pracownia_programowania.controller;

import com.s462050.pracownia_programowania.model.Kierowcy;
import com.s462050.pracownia_programowania.service.KierowcyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kierowcy") //get, post; delete, update po "/" ID
public class KierowcyController {
    private final KierowcyService kierowcyService;
    @Autowired
    public KierowcyController(KierowcyService kierowcyService) {
        this.kierowcyService = kierowcyService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Kierowcy>> findAll() {
        List<Kierowcy> allKierowcy = this.kierowcyService.findAll();
        return ResponseEntity.ok()
                .body(allKierowcy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kierowcy> findKierowca(@PathVariable("id") Long id) {
        Optional<Kierowcy> kierowca = this.kierowcyService.findById(id);
        if (kierowca.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok()
                .body(kierowca.get());
    }

    @PostMapping("/")
    public ResponseEntity<Kierowcy> addKierowca(@RequestBody Kierowcy kierowca) {
        return new ResponseEntity<>(kierowcyService.save(kierowca), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kierowcy> deleteKierowca(@PathVariable("id") Long id) {
        Optional<Kierowcy> kierowcy = this.kierowcyService.findById(id);
        if (kierowcy.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        this.kierowcyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}