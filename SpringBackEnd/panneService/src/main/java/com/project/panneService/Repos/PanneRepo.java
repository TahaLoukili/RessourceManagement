package com.project.panneService.Repos;

import com.project.panneService.models.Panne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanneRepo extends JpaRepository<Panne,Integer> {
}
