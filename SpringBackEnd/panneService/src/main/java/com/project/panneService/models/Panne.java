package com.project.panneService.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Panne {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer ressourceId;
    private Integer technicienId;
    @Column(columnDefinition = "boolean default false")
    private boolean treated;
    private LocalDate datePane;



}
