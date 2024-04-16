package com.project.panneService.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Constat {
    @Id
    @GeneratedValue
    private Integer id;
    private  String explication;
    private LocalDate dateAppartion;
    private  String frequence;
    private  String odreLogiciel;
    @Column(columnDefinition = "boolean default false")
    private  Boolean sent;
    @ManyToOne
    @JoinColumn(name = "panneId")
    private Panne panne;


}
