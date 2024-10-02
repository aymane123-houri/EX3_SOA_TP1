package com.example.ex3_tp1_soa_etudiant.service;

import com.example.ex3_tp1_soa_etudiant.DTO.EtudiantDTO;
import com.example.ex3_tp1_soa_etudiant.DTO.FiliereDTO;
import com.example.ex3_tp1_soa_etudiant.entities.Etudiant;
import com.example.ex3_tp1_soa_etudiant.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    /*public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }*/
    public List<EtudiantDTO> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        List<EtudiantDTO> responseList = new ArrayList<>();

        for (Etudiant etudiant : etudiants) {
            FiliereDTO filiere = getFiliereById(etudiant.getFiliereId());
            responseList.add(new EtudiantDTO(
                    etudiant.getIdEtudiant(),
                    etudiant.getNom(),
                    etudiant.getPrenom(),
                    etudiant.getCNE(),
                    filiere
            ));
        }

        return responseList;
    }

    /*public Etudiant getEtudiantById(int id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);

        if (etudiant != null) {
            FiliereDTO filiere = getFiliereById(etudiant.getFiliereId());
            if (filiere != null) {
                System.out.println("Filière de l'étudiant : " + filiere.getLabelle());
            } else {
                System.out.println("Filière introuvable pour l'étudiant avec ID " + etudiant.getIdEtudiant());
            }
        }

        return etudiant;
    }*/


    public EtudiantDTO getEtudiantById(int id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);

        if (etudiant != null) {
            FiliereDTO filiere = getFiliereById(etudiant.getFiliereId());
            if (filiere != null) {
                // Créer et retourner le DTO de réponse
                return new EtudiantDTO(
                        etudiant.getIdEtudiant(),
                        etudiant.getNom(),
                        etudiant.getPrenom(),
                        etudiant.getCNE(),
                        filiere
                );
            } else {
                System.out.println("Filière introuvable pour l'étudiant avec ID " + etudiant.getIdEtudiant());
                return null; // Ou gérer comme tu le souhaites
            }
        }
        return null; // Ou gérer le cas d'étudiant introuvable
    }


   /* public Etudiant createEtudiant(Etudiant etudiant) {
        // Vérifie si la filière existe avant de créer l'étudiant
        FiliereDTO filiere = getFiliereById(etudiant.getFiliereId());
        if (filiere == null) {
            throw new IllegalArgumentException("Impossible de créer l'étudiant car la filière n'existe pas.");
        }
        return etudiantRepository.save(etudiant);
    }*/

    public Etudiant createEtudiant(Etudiant etudiant) {
        FiliereDTO filiere = getFiliereById(etudiant.getFiliereId());
        if (filiere == null) {
            throw new IllegalArgumentException("Impossible de créer l'étudiant car la filière n'existe pas.");
        }
        return etudiantRepository.save(etudiant);
    }

    /*public Etudiant updateEtudiant(int id, Etudiant etudiantDetails) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant != null) {
            // Vérifie si la filière existe avant de mettre à jour l'étudiant
            FiliereDTO filiere = getFiliereById(etudiantDetails.getFiliereId());
            if (filiere == null) {
                throw new IllegalArgumentException("Impossible de mettre à jour l'étudiant car la filière n'existe pas.");
            }

            etudiant.setNom(etudiantDetails.getNom());
            etudiant.setPrenom(etudiantDetails.getPrenom());
            etudiant.setCNE(etudiantDetails.getCNE());
            etudiant.setFiliereId(etudiantDetails.getFiliereId());

            return etudiantRepository.save(etudiant);
        }
        return null;
    }


    public void deleteEtudiant(int id) {
        etudiantRepository.deleteById(id);
    }


    @Autowired
    private RestTemplate restTemplate; // Injection de RestTemplate

    // Méthode pour récupérer les informations de la filière via RestTemplate
    public FiliereDTO getFiliereById(int idFiliere) {
        String url = "http://localhost:8080/api/filieres/" + idFiliere;
        try {
            return restTemplate.getForObject(url, FiliereDTO.class);
        } catch (HttpClientErrorException.NotFound e) {
            System.out.println("La filière avec l'ID " + idFiliere + " n'existe pas.");
            return null; // Ou tu peux lever une exception
        }
    }*/

    // Méthode pour mettre à jour un étudiant
    public Etudiant updateEtudiant(int id, Etudiant etudiantDetails) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant != null) {
            FiliereDTO filiere = getFiliereById(etudiantDetails.getFiliereId());
            if (filiere == null) {
                throw new IllegalArgumentException("Impossible de mettre à jour l'étudiant car la filière n'existe pas.");
            }

            etudiant.setNom(etudiantDetails.getNom());
            etudiant.setPrenom(etudiantDetails.getPrenom());
            etudiant.setCNE(etudiantDetails.getCNE());
            etudiant.setFiliereId(etudiantDetails.getFiliereId());

            return etudiantRepository.save(etudiant);
        }
        return null; // Ou gérer le cas d'étudiant introuvable
    }

    // Méthode pour supprimer un étudiant
    public void deleteEtudiant(int id) {
        etudiantRepository.deleteById(id);
    }


    @Autowired
    private RestTemplate restTemplate; // Injection de RestTemplate
    // Méthode pour récupérer les informations de la filière via RestTemplate
    public FiliereDTO getFiliereById(int idFiliere) {
        String url = "http://localhost:8080/api/filieres/" + idFiliere;
        try {
            return restTemplate.getForObject(url, FiliereDTO.class);

        } catch (HttpClientErrorException.NotFound e) {
            System.out.println("La filière avec l'ID " + idFiliere + " n'existe pas.");
            return null; // Ou lever une exception
        }
    }

}