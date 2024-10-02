package com.example.ex3_tp1_soa_etudiant.controller;

import com.example.ex3_tp1_soa_etudiant.DTO.EtudiantDTO;
import com.example.ex3_tp1_soa_etudiant.DTO.FiliereDTO;
import com.example.ex3_tp1_soa_etudiant.entities.Etudiant;
import com.example.ex3_tp1_soa_etudiant.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
/*
    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }




    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable int id) {
        return etudiantService.getEtudiantById(id);
    }
    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.createEtudiant(etudiant);
    }

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable int id, @RequestBody Etudiant etudiantDetails) {
        return etudiantService.updateEtudiant(id, etudiantDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable int id) {
        etudiantService.deleteEtudiant(id);
    }


 */



    @Autowired
    private EtudiantService etudiantService;

    // Méthode pour récupérer tous les étudiants
    @GetMapping
    public ResponseEntity<List<EtudiantDTO>> getAllEtudiants() {
        List<EtudiantDTO> responseList = etudiantService.getAllEtudiants();
        return ResponseEntity.ok(responseList);
    }

    // Méthode pour récupérer un étudiant par ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEtudiantById(@PathVariable int id) {
        EtudiantDTO etudiantResponse = etudiantService.getEtudiantById(id);
        if (etudiantResponse != null) {
            return ResponseEntity.ok(etudiantResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étudiant introuvable avec ID " + id);
    }

    // Méthode pour créer un nouvel étudiant
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant createdEtudiant = etudiantService.createEtudiant(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEtudiant);
    }

    // Méthode pour mettre à jour un étudiant existant
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEtudiant(@PathVariable int id, @RequestBody Etudiant etudiantDetails) {
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(id, etudiantDetails);
        if (updatedEtudiant != null) {
            return ResponseEntity.ok(updatedEtudiant);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étudiant introuvable avec ID " + id);
    }

    // Méthode pour supprimer un étudiant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable int id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.noContent().build(); // Retourne un statut 204 No Content
    }
}
