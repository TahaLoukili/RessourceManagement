package com.project.ressourceService.Clients;

import com.project.ressourceService.models.Panne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="panneService" , url="${application.config.students-url}")
public interface PanneServiceClient {
    @GetMapping("/ressource/{ressource-id}")
    List<Panne> findRessourcePannes(@PathVariable("ressource-id") Integer id);
}
