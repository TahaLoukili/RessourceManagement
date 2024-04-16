package com.project.ressourceService.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Imprimante extends  Ressource{
    private Double vitesseImpression;
    private Double resolution;
}
