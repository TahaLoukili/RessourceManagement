package com.project.panneService.service;

import com.project.panneService.Repos.ConstatRepo;
import com.project.panneService.Repos.PanneRepo;
import com.project.panneService.models.Constat;
import com.project.panneService.models.Panne;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PanneService {

    private final ConstatRepo constatRepo;
    private final PanneRepo panneRepo;


    // CRUD operations for Panne

    public Panne savePanne(Panne panne) {
        return panneRepo.save(panne);
    }

    public List<Panne> getAllPannes() {
        return panneRepo.findAll();
    }

    public Optional<Panne> getPanneById(Integer id) {
        return panneRepo.findById(id);
    }

    public void deletePanne(Integer id) {
        panneRepo.deleteById(id);
    }

    public Panne updatePanne(Panne updatedPanne) {
        // Make sure the resource exists before updating
        Optional<Panne> existingPanneOptional = panneRepo.findById(updatedPanne.getId());
        if (existingPanneOptional.isPresent()) {
            Panne existingPanne = existingPanneOptional.get();
            // Update fields based on the updatedRessource
            existingPanne.setDatePane(updatedPanne.getDatePane());
            existingPanne.setTreated(updatedPanne.isTreated());
            existingPanne.setRessourceId(updatedPanne.getRessourceId());
            existingPanne.setTechnicienId(updatedPanne.getTechnicienId());
            // Save the updated resource
            return panneRepo.save(existingPanne);
        } else {
            // Throw an exception or handle appropriately if the resource doesn't exist
            // For simplicity, let's return null here
            return null;
        }
    }



    // CRUD operations for Constat

    public Constat saveConstat(Constat constat) {
        return constatRepo.save(constat);
    }

    public List<Constat> getAllConstats() {
        return constatRepo.findAll();
    }

    public Optional<Constat> getConstatById(Integer id) {
        return constatRepo.findById(id);
    }

    public void deleteConstat(Integer id) {
        constatRepo.deleteById(id);
    }

    public Constat updateConstat(Constat updatedConstat) {
        // Make sure the resource exists before updating
        Optional<Constat> existingConstatOptional = constatRepo.findById(updatedConstat.getId());
        if (existingConstatOptional.isPresent()) {
            Constat existingConstat = existingConstatOptional.get();
            // Update fields based on the updatedConstat
            existingConstat.setPanne(updatedConstat.getPanne());
            existingConstat.setExplication(updatedConstat.getExplication());
            existingConstat.setSent(updatedConstat.getSent());
            existingConstat.setFrequence(updatedConstat.getFrequence());
            existingConstat.setOdreLogiciel(updatedConstat.getOdreLogiciel());
            existingConstat.setDateAppartion(updatedConstat.getDateAppartion());

            // Save the updated resource
            return constatRepo.save(existingConstat);
        } else {
            // Throw an exception or handle appropriately if the resource doesn't exist
            // For simplicity, let's return null here
            return null;
        }
    }


    public List<Panne> getAllRessourcesPannes(Integer id) {


        return  panneRepo.findAllByressourceId(id);
    }
}
