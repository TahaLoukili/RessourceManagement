package com.project.ressourceService.service;

import com.project.ressourceService.models.Imprimante;
import com.project.ressourceService.models.Ordinateur;
import com.project.ressourceService.models.Ressource;
import com.project.ressourceService.repo.ImprimanteRepo;
import com.project.ressourceService.repo.OrdinateurRepo;
import com.project.ressourceService.repo.RessourceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RessourceService {
    private final RessourceRepo ressourceRepo;
    private final OrdinateurRepo ordinateurRepo;
    private final ImprimanteRepo imprimanteRepo;

    // CRUD operations for Ressource

    public Ressource save(Ressource ressource) {
        return ressourceRepo.save(ressource);
    }

    public List<Ressource> getAllRessources() {
        return ressourceRepo.findAll();
    }

    public Optional<Ressource> getRessourceById(Integer id) {
        return ressourceRepo.findById(id);
    }

    public void deleteRessource(Integer id) {
        ressourceRepo.deleteById(id);
    }

    public Ressource updateRessource(Ressource updatedRessource) {
        // Make sure the resource exists before updating
        Optional<Ressource> existingRessourceOptional = ressourceRepo.findById(updatedRessource.getId());
        if (existingRessourceOptional.isPresent()) {
            Ressource existingRessource = existingRessourceOptional.get();
            // Update fields based on the updatedRessource
            existingRessource.setMarque(updatedRessource.getMarque());
            existingRessource.setDepartementId(updatedRessource.getDepartementId());
            existingRessource.setEnseignantId(updatedRessource.getEnseignantId());
            // Save the updated resource
            return ressourceRepo.save(existingRessource);
        } else {
            // Throw an exception or handle appropriately if the resource doesn't exist
            // For simplicity, let's return null here
            return null;
        }
    }

    // CRUD operations specific to Ordinateur

    public Ordinateur saveOrdinateur(Ordinateur ordinateur) { return ordinateurRepo.save(ordinateur);
    }

    public List<Ordinateur> getAllOrdinateurs() {
        return ordinateurRepo.findAll();
    }

    public Optional<Ordinateur> getOrdinateurById(Integer id) {
        return ordinateurRepo.findById(id);
    }

    public void deleteOrdinateur(Integer id) {
        ressourceRepo.deleteById(id);
    }

    public Ordinateur updateOrdinateur(Ordinateur updatedOrdinateur) {
        // Make sure the resource exists before updating
        Optional<Ordinateur> existingOrdinateurOptional =  ordinateurRepo.findById(updatedOrdinateur.getId());
        if (existingOrdinateurOptional.isPresent()) {
            Ordinateur existingOrdinateur = existingOrdinateurOptional.get();
            // Update fields based on the updatedRessource
            existingOrdinateur.setMarque(updatedOrdinateur.getMarque());
            existingOrdinateur.setDepartementId(updatedOrdinateur.getDepartementId());
            existingOrdinateur.setEnseignantId(updatedOrdinateur.getEnseignantId());
            existingOrdinateur.setCPU(updatedOrdinateur.getCPU());
            existingOrdinateur.setRAM(updatedOrdinateur.getRAM());
            existingOrdinateur.setEcran(updatedOrdinateur.getEcran());
            existingOrdinateur.setDisqueDur(updatedOrdinateur.getDisqueDur());

            // Save the updated resource
            return ressourceRepo.save(existingOrdinateur);
        } else {
            // Throw an exception or handle appropriately if the resource doesn't exist
            // For simplicity, let's return null here
            return null;
        }
    }



    // CRUD operations specific to Imprimante

    public Imprimante saveImprimante(Imprimante imprimante) {
        return imprimanteRepo.save(imprimante);
    }

    public List<Imprimante> getAllImprimantes() {
        return imprimanteRepo.findAll();
    }

    public Optional<Imprimante> getImprimanteById(Integer id) {
        return imprimanteRepo.findById(id);
    }

    public void deleteImprimante(Integer id) {
        imprimanteRepo.deleteById(id);
    }
    public Imprimante updateImprimante(Imprimante updatedImprimante) {
        // Make sure the resource exists before updating
        Optional<Imprimante> existingImprimanteOptional = imprimanteRepo.findById(updatedImprimante.getId());
        if (existingImprimanteOptional.isPresent()) {
            Imprimante existingImprimante = existingImprimanteOptional.get();
            // Update fields based on the updatedImprimante
            existingImprimante.setMarque(updatedImprimante.getMarque());
            existingImprimante.setDepartementId(updatedImprimante.getDepartementId());
            existingImprimante.setEnseignantId(updatedImprimante.getEnseignantId());
            existingImprimante.setVitesseImpression(updatedImprimante.getVitesseImpression());
            existingImprimante.setResolution(updatedImprimante.getResolution());
            // Save the updated resource
            return  imprimanteRepo.save(existingImprimante);
        } else {
            // Throw an exception or handle appropriately if the resource doesn't exist
            // For simplicity, let's return null here
            return null;
        }
    }



}
