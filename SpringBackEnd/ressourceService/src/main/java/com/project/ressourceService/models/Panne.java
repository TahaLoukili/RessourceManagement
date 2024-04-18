package com.project.ressourceService.models;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Panne {
    private Integer id;
    private Integer ressourceId;
    private Integer technicienId;

    private boolean treated;
    private LocalDate datePane;
}
