package com.example.ex3_tp1_soa_etudiant.repository;


import com.example.ex3_tp1_soa_etudiant.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}