package com.example.ex3_tp1_soa_etudiant.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FiliereDTO {
    private int idFiliere;
    private String code;
    private String labelle;
}
