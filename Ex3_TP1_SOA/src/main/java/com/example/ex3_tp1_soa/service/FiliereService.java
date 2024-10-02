package com.example.ex3_tp1_soa.service;

import com.example.ex3_tp1_soa.entities.Filiere;
import com.example.ex3_tp1_soa.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    public Filiere getFiliereById(int id) {
        return filiereRepository.findById(id).orElse(null);
    }

    public Filiere createFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    public Filiere updateFiliere(int id, Filiere filiere) {
        return filiereRepository.findById(id).map(filiere1 -> {
            filiere1.setCode(filiere.getCode());
            filiere1.setLabelle(filiere.getLabelle());

            return filiereRepository.save(filiere1);
        }).orElseThrow(()-> new RuntimeException("pas existe"));
    }

    public void deleteFiliere(int id) {
        filiereRepository.deleteById(id);
    }
}
