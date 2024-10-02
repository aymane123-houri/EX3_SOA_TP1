package com.example.ex3_tp1_soa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Filiere {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idFiliere;

        @Column(name = "code", length = 100)
        private String code;

        @Column(name = "labelle", length = 100)
        private String labelle;

}
