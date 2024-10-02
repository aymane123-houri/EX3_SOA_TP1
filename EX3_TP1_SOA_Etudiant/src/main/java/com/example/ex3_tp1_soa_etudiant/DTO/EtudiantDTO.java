package com.example.ex3_tp1_soa_etudiant.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDTO {
    private int idEtudiant;
    private String nom;
    private String prenom;
    private String CNE;
    private FiliereDTO filiere; // Inclus le DTO de la filière
}
