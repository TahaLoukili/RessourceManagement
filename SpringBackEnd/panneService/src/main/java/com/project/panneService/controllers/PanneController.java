package com.project.panneService.controllers;

import com.project.panneService.models.Constat;
import com.project.panneService.models.Panne;
import com.project.panneService.service.PanneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/panneService")
@RequiredArgsConstructor

public class PanneController {

    private final PanneService panneService;
    //panne
    @GetMapping("/all-pannes")
    public ResponseEntity<List<Panne>> getAllPannee(){

        return new ResponseEntity<>(panneService.getAllPannes(), HttpStatus.OK);
    }
    @GetMapping("/find-panne/{id}")
    public  ResponseEntity<Optional<Panne>> getPanneById(@PathVariable Integer id){
        return  new ResponseEntity<>(panneService.getPanneById(id),HttpStatus.OK);

    }

    @PostMapping("/add-panne")
    public  ResponseEntity<Panne> addPanne(@RequestBody Panne p){

        return new ResponseEntity<>(panneService.savePanne(p),HttpStatus.CREATED);
    }
    @PutMapping("/update-panne")
    public  ResponseEntity<Panne> updatePanne(@RequestBody Panne p){

        Panne ressource=panneService.updatePanne(p);
        return new ResponseEntity<>(ressource,HttpStatus.OK);

    }

    @PostMapping("/delete-panne/{id}")
    public  ResponseEntity<Panne> deletePanne(@PathVariable("id") Integer id){

        panneService.deletePanne(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //for constat

    @GetMapping("/all-constat")
    public ResponseEntity<List<Constat>> getAllConstat(){
        List<Constat> listConstats=panneService.getAllConstats();
        return new ResponseEntity<>(listConstats,HttpStatus.OK);
    }

    @GetMapping("/find-constat/{id}")
    public  ResponseEntity<Optional<Constat>> getConstatById(@PathVariable Integer id){

        return  new ResponseEntity<>(panneService.getConstatById(id),HttpStatus.OK);
    }
    @PostMapping("/add-constat")
    public  ResponseEntity<Constat> addConstat(@RequestBody Constat c){

        return new ResponseEntity<>(panneService.saveConstat(c),HttpStatus.CREATED);
    }
    @PostMapping("/delete-constat/{id}")
    public  ResponseEntity<Constat> deleteConstat(@PathVariable("id") Integer id){

        panneService.deleteConstat(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PutMapping("/update-constat")
    public  ResponseEntity<Constat> updateConstat(@RequestBody Constat c){

        Constat constat=panneService.updateConstat(c);
        return new ResponseEntity<>(constat,HttpStatus.OK);

    }

    //communication avec le service de  ressource
    @GetMapping("/ressource/{recource-id}")
    public ResponseEntity<List<Panne>> getAllRessourcesPannes(@PathVariable("recource-id") Integer id){

        return new ResponseEntity<>(panneService.getAllRessourcesPannes(id), HttpStatus.OK);
    }
}
