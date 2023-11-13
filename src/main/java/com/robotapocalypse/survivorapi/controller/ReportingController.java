package com.robotapocalypse.survivorapi.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.robotapocalypse.survivorapi.model.Survivor;
import com.robotapocalypse.survivorapi.service.SurvivorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survivors")

class ReportingController {
    @Autowired
    private SurvivorService survivorService;


    @GetMapping("/reports/infectedPercentage")
    public ResponseEntity<String> getInfectedPercentage() {
        double percentage = survivorService.calculatePercentageOfInfectedSurvivors();
        return ResponseEntity.ok("Infected Percentage : "+(percentage + "%"));
    }

    @GetMapping("/reports/nonInfectedPercentage")
    public ResponseEntity<String > getNonInfectedPercentage() {
        double percentage = survivorService.calculatePercentageOfNonInfectedSurvivors();
        return ResponseEntity.ok("Non Infected Percentage : "+percentage + "%");
    }

    @GetMapping("/reports/infectedSurvivors")
    public ResponseEntity<List<Survivor>> getInfectedSurvivors() {
        List<Survivor> infectedSurvivors = survivorService.getInfectedSurvivors();
        return ResponseEntity.ok(infectedSurvivors);
    }

    @GetMapping("/reports/nonInfectedSurvivors")
    public ResponseEntity<List<Survivor> >getNonInfectedSurvivors() {
        List<Survivor> nonInfectedSurvivors = survivorService.getNonInfectedSurvivors();
        return ResponseEntity.ok(nonInfectedSurvivors);
    }

    @GetMapping("/reports/robots")
    public ResponseEntity<JsonNode> getRobots() {
        JsonNode robots = survivorService.getRobots();
        return ResponseEntity.ok(robots);
    }
}

