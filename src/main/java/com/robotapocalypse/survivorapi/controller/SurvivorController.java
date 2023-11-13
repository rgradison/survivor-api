package com.robotapocalypse.survivorapi.controller;

import com.robotapocalypse.survivorapi.model.Survivor;
import com.robotapocalypse.survivorapi.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/survivors")

class SurvivorController {
    @Autowired
    private SurvivorService survivorService;

    @PostMapping
    public ResponseEntity<Survivor> addSurvivor(@RequestBody Survivor survivor) {
        Survivor savedSurvivor = survivorService.addSurvivor(survivor);
        return ResponseEntity.ok(savedSurvivor);
    }

    @PutMapping("/location")
    public ResponseEntity updateLocation(@RequestBody Survivor survivor) {
        Survivor survivor1 = survivorService.getSurvivorById(survivor.getSurvivorId());
        if(survivor1 == null) {
            return ResponseEntity.notFound().build();
        }

        survivorService.updateLocation(survivor1.getId(), survivor1.getLastLocation());
        return ResponseEntity.ok("Location updated");
    }

    @GetMapping("/infect/{survivorId}")
    public ResponseEntity flagInfected(@PathVariable String survivorId) {
        survivorService.flagAsInfected(survivorId);
        return ResponseEntity.ok("survivor status updated");
    }

    @GetMapping
    public ResponseEntity<List<Survivor>> getAllSurvivors() {
        List<Survivor> survivors = survivorService.getAllSurvivors();
        return ResponseEntity.ok(survivors);
    }

    @GetMapping("/{survivorId}")
    public ResponseEntity<Survivor> getSurvivorById(@PathVariable String survivorId) {
        Survivor survivor = survivorService.getSurvivorById(survivorId);
        return ResponseEntity.ok(survivor);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Survivor>> searchSurvivorByName(@RequestParam String name) {
        return ResponseEntity.ok(survivorService.searchSurvivorByName(name));
    }
}

