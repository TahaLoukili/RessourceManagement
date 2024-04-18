package com.project.ressourceService.controllers;
import com.project.ressourceService.models.Imprimante;
import com.project.ressourceService.models.Ordinateur;
import com.project.ressourceService.models.Panne;
import com.project.ressourceService.models.Ressource;
import com.project.ressourceService.service.RessourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ressourceService")
@RequiredArgsConstructor
public class RessourceController {
    private final RessourceService ressourceService;



    //ressource
    @GetMapping("/all")
    public ResponseEntity<List<Ressource>> getAllRessource(){

        return new ResponseEntity<>(ressourceService.getAllRessources(), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public  ResponseEntity<Optional<Ressource>> getRessourceById(@PathVariable Integer id){
        return  new ResponseEntity<>(ressourceService.getRessourceById(id),HttpStatus.OK);

    }

    @PostMapping("/add")
    public  ResponseEntity<Ressource> addRessource(@RequestBody Ressource r){

        return new ResponseEntity<>(ressourceService.save(r),HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public  ResponseEntity<Ressource> updateRessource(@RequestBody Ressource r){

        Ressource ressource=ressourceService.updateRessource(r);
        return new ResponseEntity<>(ressource,HttpStatus.OK);

    }

    @PostMapping("/delete/{id}")
    public  ResponseEntity<Ressource> deleteRessource(@PathVariable("id") Integer id){

        ressourceService.deleteRessource(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //for ordinateur

    @GetMapping("/all-ordinateur")
    public ResponseEntity<List<Ordinateur>> getAllOrdinateur(){
        List<Ordinateur> listOrdinateur=ressourceService.getAllOrdinateurs();
        return new ResponseEntity<>(listOrdinateur,HttpStatus.OK);
    }

    @GetMapping("/find-ordinateur/{id}")
    public  ResponseEntity<Optional<Ordinateur>> getOrdinateurById(@PathVariable Integer id){

        return  new ResponseEntity<>(ressourceService.getOrdinateurById(id),HttpStatus.OK);
    }
    @PostMapping("/add-ordinateur")
    public  ResponseEntity<Ordinateur> addOrinateur(@RequestBody Ordinateur o){

        return new ResponseEntity<>(ressourceService.saveOrdinateur(o),HttpStatus.CREATED);
    }
    @PostMapping("/delete-ordinateur/{id}")
    public  ResponseEntity<Ordinateur> deleteOrdinateur(@PathVariable("id") Integer id){

        ressourceService.deleteOrdinateur(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PutMapping("/update-ordinateur")
    public  ResponseEntity<Ordinateur> updateOridnateur(@RequestBody Ordinateur o){

        Ordinateur ordinateur=ressourceService.updateOrdinateur(o);
        return new ResponseEntity<>(ordinateur,HttpStatus.OK);

    }

    //for Imprimante

    @GetMapping("/all-imprimante")
    public ResponseEntity<List<Imprimante>> getAllImprimante(){
        List<Imprimante> listImprimante=ressourceService.getAllImprimantes();
        return new ResponseEntity<>(listImprimante,HttpStatus.OK);
    }

    @GetMapping("/find-imprimante/{id}")
    public  ResponseEntity<Optional<Imprimante>> getImprimanteById(@PathVariable Integer id){

        return  new ResponseEntity<>(ressourceService.getImprimanteById(id),HttpStatus.OK);
    }
    @PostMapping("/add-imprimante")
    public  ResponseEntity<Imprimante> addImprimante(@RequestBody Imprimante i){

        return new ResponseEntity<>(ressourceService.saveImprimante(i),HttpStatus.CREATED);
    }
    @PostMapping("/delete-imprimante/{id}")
    public  ResponseEntity<Imprimante> deleteImprimante(@PathVariable("id") Integer id){

        ressourceService.deleteImprimante(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PutMapping("/update-imprimante")
    public  ResponseEntity<Imprimante> updateImprimante(@RequestBody Imprimante i){

        Imprimante imprimante=ressourceService.updateImprimante(i);
        return new ResponseEntity<>(imprimante,HttpStatus.OK);

    }


    //communication avec panne microservice
    @GetMapping("/list-pannes/{ressource-id}")
    public  ResponseEntity<List<Panne>> getRessourcePaanes(@PathVariable("ressource-id") Integer id){

        return  new ResponseEntity<>(ressourceService.findRessourcePanne(id),HttpStatus.OK);
    }







}
