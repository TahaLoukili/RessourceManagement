package com.project.panneService.Repos;

import com.project.panneService.models.Panne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanneRepo extends JpaRepository<Panne,Integer> {
    List<Panne> findAllByressourceId(Integer id);
}
