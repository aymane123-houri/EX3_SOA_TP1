package com.example.ex3_tp1_soa.controller;

import com.example.ex3_tp1_soa.entities.Filiere;
import com.example.ex3_tp1_soa.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public List<Filiere> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    @GetMapping("/{id}")
    public Filiere getFiliereById(@PathVariable int id) {
        return filiereService.getFiliereById(id);
    }

    @PostMapping
    public Filiere createFiliere(@RequestBody Filiere filiere) {
        return filiereService.createFiliere(filiere);
    }

    @PutMapping("/{id}")
    public Filiere updateFiliere(@PathVariable int id, @RequestBody Filiere filiereDetails) {
        return filiereService.updateFiliere(id, filiereDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFiliere(@PathVariable int id) {
        filiereService.deleteFiliere(id);
    }
}
