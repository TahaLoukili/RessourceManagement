package com.project.ressourceService.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Ordinateur extends  Ressource{
    private  String CPU;
    private  String RAM;
    private String ecran;
    private String disqueDur;

}
