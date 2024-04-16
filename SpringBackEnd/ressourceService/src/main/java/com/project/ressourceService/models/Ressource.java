package com.project.ressourceService.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Ressource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Integer id;
    private String marque;
    private Integer departementId;
    private Integer enseignantId;
    @Column(unique = true)
    private String NumeroInventaire;
    private double prix;
    @Column(columnDefinition = "boolean default false")
    private boolean panne;
    private Integer livraisonId;
    private Integer duree_garentie;
    private Integer appelOffreId;


}
